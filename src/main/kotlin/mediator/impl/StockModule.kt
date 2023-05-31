package impl

import dto.ProductRequest
import dto.SaleOrder
import module.AbstractModule
import module.ModuleMediator
import module.ModuleMessage

class StockModule : AbstractModule() {
    var mediator: ModuleMediator = ModuleMediator.getInstance()

    companion object {
        const val MODULE_NAME = "Stock"
        const val OPERATION_DECREMENT_STOCK = "DecrementStock"
    }

    override fun getModuleName(): String {
        return MODULE_NAME
    }

    override fun completeOrder(saleOrder: SaleOrder) {
        TODO("Not yet implemented")
    }

    override fun notifyMessage(message: ModuleMessage): Any {
        when (message.getMessageType()) {
            OPERATION_DECREMENT_STOCK -> return decrementStock(message)!!
            else -> throw RuntimeException("Operación no soportada '${message.getMessageType()}'")
        }
    }

    private fun decrementStock(message: ModuleMessage): Void? {
        val saleOrder = message.getPayload() as SaleOrder
        for (product in saleOrder.getProductos()) {
            println("decrement product > ${product.getName()}")
        }

        val productRequest = ProductRequest()
        productRequest.setProducts(saleOrder.getProductos())

        val purchaseMessage = ModuleMessage(
            MODULE_NAME,
            PurchaseModule.MODULE_NAME,
            PurchaseModule.OPERATION_PURCHASE_REQUEST,
            productRequest
        )
        mediator!!.mediate(purchaseMessage)
        return null
    }
}