package composite

import java.text.DecimalFormat
import java.text.NumberFormat

class SaleOrder(private val orderId: Long, private val customer: String) {
    private val products: MutableList<AbstractProduct> = ArrayList()

    val price: Double
        get() {
            var price = 0.0
            for (child: AbstractProduct in products) {
                price += child.price
            }
            return price
        }

    fun addProduct(product: AbstractProduct) {
        products.add(product)
    }

    fun printOrder() {
        val formater: NumberFormat = DecimalFormat("###,##0.00")
        println(
                "\\\n============================================="
                        + "\nOrden: " + orderId + "\nCliente: " + customer
                        + "\nProductos:\n"
        )
        for (prod: AbstractProduct in products) {
            println(
                    (prod.name + "\t\t\t$ "
                            + formater.format(prod.price))
            )
        }
        println(
                ("Total: " + formater.format(price)
                        + "\n=============================================")
        )
    }
    /** GET and SET  */
}