package crm

import dto.SaleOrder
import module.AbstractModule
import module.ModuleMessage

class DistributionModule: AbstractModule() {
    companion object {
        const val MODULE_NAME = "ECommerce"
        const val OPERATION_COMPLETE_ORDER = "CompleteOrder"
    }

    override fun getModuleName(): String {
        return MODULE_NAME;
    }

    override fun completeOrder(saleOrder: SaleOrder) {
        println("Orden completada en el módulo Email")
    }

    override fun notifyMessage(message: ModuleMessage): Any {
        return when (message.messageType) {
            OPERATION_COMPLETE_ORDER -> {
                scheduleDelivery(message)
            }
            else -> {
                throw RuntimeException("Operación no soportada '${message.messageType}'")
            }
        }!!
    }

    private fun scheduleDelivery(message: ModuleMessage): Void? {
        val saleOrder = message.getSource() as SaleOrder
        println("Programando envío del pedido: ${saleOrder.id}")
        // Lógica para programar el envío del producto al cliente
        return null
    }
}