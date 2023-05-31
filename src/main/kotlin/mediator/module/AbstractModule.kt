package module

import dto.SaleOrder

abstract class AbstractModule {

    private lateinit var mediator: ModuleMediator

    abstract fun getModuleName(): String

    fun activate() {
        mediator = ModuleMediator.getInstance()
        mediator.registerModule(this)
    }

    abstract fun completeOrder(saleOrder: SaleOrder)

    abstract fun notifyMessage(message: ModuleMessage): Any
}