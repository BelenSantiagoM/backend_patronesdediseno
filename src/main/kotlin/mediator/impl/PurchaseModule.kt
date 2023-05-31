package impl

import dto.SaleOrder
import module.AbstractModule
import module.ModuleMessage

class PurchaseModule : AbstractModule() {

    companion object {
        const val MODULE_NAME = "Chopping"
        const val OPERATION_PURCHASE_REQUEST = "PurchaseRequest"
    }

    override fun getModuleName(): String {
        return MODULE_NAME
    }

    override fun completeOrder(saleOrder: SaleOrder) {
        TODO("Not yet implemented")
    }

    override fun notifyMessage(message: ModuleMessage): Any {
        if (message == null){
            println("Valor nulo")
        }

        when (message!!.getMessageType()) {
            OPERATION_PURCHASE_REQUEST -> return purchaseRequest(message)!!
            else -> throw RuntimeException("Operación no soportada '${message!!.getMessageType()}'")
        }

    }

    private fun purchaseRequest(message: ModuleMessage): Void? {
        return null
    }
}