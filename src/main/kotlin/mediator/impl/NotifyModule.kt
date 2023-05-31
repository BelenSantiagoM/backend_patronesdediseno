package impl

import dto.SaleOrder
import module.AbstractModule
import module.ModuleMessage

class NotifyModule : AbstractModule() {

    companion object {
        const val MODULE_NAME = "Notification"
        const val OPERATION_NOTIFY = "Notify"
    }

    override fun getModuleName(): String {
        return MODULE_NAME
    }

    override fun completeOrder(saleOrder: SaleOrder) {
        TODO("Not yet implemented")
    }

    override fun notifyMessage(message: ModuleMessage): Any {
        when (message.getMessageType()) {
            OPERATION_NOTIFY -> return notify(message)!!
            else -> throw RuntimeException("Operación no soportada '${message.getMessageType()}'")
        }
    }

    private fun notify(message: ModuleMessage): Void? {
        println("Notificación por EMail enviada")
        return null
    }
}