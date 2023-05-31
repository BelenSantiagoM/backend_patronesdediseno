import dto.Product
import dto.Sale
import impl.*
import java.lang.NullPointerException

fun main() {
    CRMModule().activate()
    NotifyModule().activate()
    StockModule().activate()
    PurchaseModule().activate()

    val client = ECommerceModule()
    client.activate()

    val sale = Sale()
    for (c in 0 until 5) {
        sale.addProduct(Product("Product" + (c + 1)))
    }

    try {
        client.createSale(sale)

    } catch (e: NullPointerException){
        println("Operacion terminada")
    }
}