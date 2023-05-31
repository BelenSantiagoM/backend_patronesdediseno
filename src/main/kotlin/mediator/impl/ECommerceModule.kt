package impl

import dto.Sale
import dto.SaleOrder
import module.AbstractModule
import module.ModuleMediator
import module.ModuleMessage

class ECommerceModule : AbstractModule() {

    var mediator: ModuleMediator = ModuleMediator.getInstance()

    companion object {
        const val MODULE_NAME = "ECommerce"
        const val OPERATION_COMPLETE_ORDER = "CompleteOrder"
    }

    override fun getModuleName(): String {
        return MODULE_NAME
    }

    override fun completeOrder(saleOrder: SaleOrder) {
        println("Orden completada en el módulo ECommerceModule")
    }

    override fun notifyMessage(message: ModuleMessage): Any {
        when (message.getMessageType()) {
            OPERATION_COMPLETE_ORDER -> return completeOrder(message)
            else -> throw RuntimeException("Operación no soportada '${message.getMessageType()}'")
        }
    }

    private fun completeOrder(message: ModuleMessage): String {
        val saleOrder = message.getPayload() as SaleOrder
        println("Orden completada exitosamente > ")

        val crmMessage = ModuleMessage(
            MODULE_NAME,
            NotifyModule.MODULE_NAME,
            NotifyModule.OPERATION_NOTIFY,
            saleOrder
        )
        mediator!!.mediate(crmMessage)
        return saleOrder.getId()
    }

    fun createSale(sale: Sale): String {
        val crmMessage = ModuleMessage(
            MODULE_NAME,
            CRMModule.MODULE_NAME,
            CRMModule.OPERATION_CREATE_ORDER,
            sale
        )
        return mediator!!.mediate(crmMessage).toString()
    }
}