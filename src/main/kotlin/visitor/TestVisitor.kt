package visitor

import javax.xml.bind.JAXBContext
import javax.xml.bind.Unmarshaller

object VisitorMain {
    @JvmStatic
    fun main(args: Array<String>) {
        var project: Project? = null
        try {
            val context = JAXBContext.newInstance(Project::class.java)
            val unmarshaller: Unmarshaller = context.createUnmarshaller()
            project = unmarshaller.unmarshal(VisitorMain::class.java.getResourceAsStream("Project.xml")) as Project
        } catch (e: Exception) {
            println(e.message)
            e.printStackTrace()
        }

        // Obtener el costo total del proyecto
        val costVisitor = CostProjectVisitor()
        project?.accept(costVisitor)
        val cost: Double = costVisitor.getResult().toDouble()
        println("Total cost > $cost")

        // Obtener el precio de venta del proyecto
        val priceVisitor = PriceProjectVisitor()
        project?.accept(priceVisitor)
        val price: Double = priceVisitor.getResult().toDouble()
        println("Total price > $price")
        println("Total gain > ${price - cost}")

        // Mostrar el total a pagar por empleado
        println("\n:::::::: Pay the workers :::::::")
        val paymentVisitor = PaymentProjectVisitor()
        project?.accept(paymentVisitor)
        val result: List<EmployeePay> = paymentVisitor.getResult()
        for (pay in result) {
            println("${pay.employeeName} > ${pay.totalPay}")
        }
    }
}
