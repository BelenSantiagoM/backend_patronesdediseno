package composite

import java.util.*

class CompositeMain {
    private val random = Random()
    private var ram4gb: SimpleProduct? = null
    private var ram8gb: SimpleProduct? = null
    private var disk500gb: SimpleProduct? = null
    private var disk1tb: SimpleProduct? = null
    private var cpuAMD: SimpleProduct? = null
    private var cpuIntel: SimpleProduct? = null
    private var smallCabinete: SimpleProduct? = null
    private var bigCabinete: SimpleProduct? = null
    private var monitor20inch: SimpleProduct? = null
    private var monitor30inch: SimpleProduct? = null
    private var simpleMouse: SimpleProduct? = null
    private var gammerMouse: SimpleProduct? = null
    private var gammerPC: CompositeProduct? = null
    private var homePC: CompositeProduct? = null
    private var pc2x1: CompositeProduct? = null
    fun buildProducts() {
//Construcción de productos simples
        ram4gb = SimpleProduct("Memoria RAM 4GB", 750.0, "KingStone")
        ram8gb = SimpleProduct("Memoria RAM 8GB", 1000.0, "KingStone")
        disk500gb = SimpleProduct("Disco Duro 500GB", 1500.0, "ACME")
        disk1tb = SimpleProduct("Disco Duro 1TB", 2000.0, "ACME")
        cpuAMD = SimpleProduct("AMD phenon", 4000.0, "AMD")
        cpuIntel = SimpleProduct("Intel i7", 4500.0, "Intel")
        smallCabinete = SimpleProduct("Gabinete Pequeï¿½o", 2000.0, "ExCom")
        bigCabinete = SimpleProduct("Gabinete Grande", 2200.0, "ExCom")
        monitor20inch = SimpleProduct("Monitor 20'", 1500.0, "HP")
        monitor30inch = SimpleProduct("Monitor 30'", 2000.0, "HP")
        simpleMouse = SimpleProduct("Raton Simple", 150.0, "Genius")
        gammerMouse = SimpleProduct("Raton Gammer", 750.0, "Alien")

//Computadora para Gammer que incluye 8gb de ram,disco de 1tb, procesador Intel i7
//Gabinete grande, monitor de 30' y un mouse gammer.
        gammerPC = CompositeProduct("Gammer PC")
        gammerPC!!.addProduct(ram8gb!!)
        gammerPC!!.addProduct(disk1tb!!)
        gammerPC!!.addProduct(cpuIntel!!)
        gammerPC!!.addProduct(bigCabinete!!)
        gammerPC!!.addProduct(monitor30inch!!)
        gammerPC!!.addProduct(gammerMouse!!)

//Computadora para Casa que incluye 4gb de ram,disco de 500gb, procesador AMD Phenon
//Gabinete chico, monitor de 20' y un mouse simple.
        homePC = CompositeProduct("Casa PC")
        homePC!!.addProduct(ram4gb!!) //
        homePC!!.addProduct(disk500gb!!)
        homePC!!.addProduct(cpuAMD!!)
        homePC!!.addProduct(smallCabinete!!)
        homePC!!.addProduct(monitor20inch!!)
        homePC!!.addProduct(simpleMouse!!)

//Paque compuesto de dos paquetes: paquete Gammer PC y Home PC
        pc2x1 = CompositeProduct("Paquete PC Gammer + Casa")
        pc2x1!!.addProduct(gammerPC!!)
        pc2x1!!.addProduct(homePC!!)
    }

    fun orderSimpleProducts() {
        val simpleProductOrder = SaleOrder(random.nextInt().toLong(), "Rene Blancarte")
        simpleProductOrder.addProduct(ram4gb!!)
        simpleProductOrder.addProduct(disk1tb!!)
        simpleProductOrder.addProduct(simpleMouse!!)
        simpleProductOrder.printOrder()
    }

    fun orderGammerPC() {
        val gammerOrder = SaleOrder(1, "Juan Perez")
        gammerOrder.addProduct(gammerPC!!)
        gammerOrder.printOrder()
    }

    fun orderHomePC() {
        val homeOrder = SaleOrder(2, "Marcos Guerra")
        homeOrder.addProduct(homePC!!)
        homeOrder.printOrder()
    }

    fun orderCombo() {
        val comboOrder = SaleOrder(3, "Paquete 2x1 en PC")
        comboOrder.addProduct(pc2x1!!)
        comboOrder.printOrder()
    }

    fun orderBig() {
        val customOrder = SaleOrder(4, "Oscar Blancarte")
        customOrder.addProduct(homePC!!)
        customOrder.addProduct(ram8gb!!)
        customOrder.addProduct(ram4gb!!)
        customOrder.addProduct(monitor30inch!!)
        customOrder.addProduct(gammerMouse!!)
        customOrder.printOrder()
    }

    companion object {
        /*@JvmStatic
        fun main(args: Array<String>) {
            val main = CompositeMain()
            main.buildProducts()
            main.orderSimpleProducts()
            main.orderHomePC()
            main.orderGammerPC()
            main.orderCombo()
            main.orderBig()
        }*/

        @JvmStatic
        fun main(args: Array<String>) {
            val main = CompositeMain()
            main.buildProducts()
            main.orderSimpleProducts()
// main.orderHomePC();
// main.orderGammerPC();
// main.orderCombo();
// main.orderBig();
        }
    }
}