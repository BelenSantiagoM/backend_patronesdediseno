package module

import java.util.HashMap

class ModuleMediator() {

    companion object {
        var mediator: ModuleMediator? = null

        private val modules: MutableMap<String, AbstractModule> = HashMap()

        @Synchronized
        fun getInstance(): ModuleMediator {
            if (mediator == null) {
                mediator = ModuleMediator()
            }
            return mediator!!
        }
    }

    fun registerModule(module: AbstractModule) {
        modules[module.getModuleName()] = module
    }

    fun mediate(mediateEvent: ModuleMessage): Any {
        if (!modules.containsKey(mediateEvent.getTarget())) {
            throw RuntimeException("El módulo '${mediateEvent.getTarget()}' no está registrado")
        }

        println("Mediate source > '${mediateEvent.getSource()}', target > '${mediateEvent.getTarget()}', messagetType > '${mediateEvent.getMessageType()}'")

        val module: AbstractModule? = modules[mediateEvent.getTarget()]
        return module!!.notifyMessage(mediateEvent) ?: throw RuntimeException("El módulo '${mediateEvent.getTarget()}' no está registrado")
    }

    fun measureExecutionTime(action: () -> Unit) {
        val startTime = System.currentTimeMillis()
        action()
        val endTime = System.currentTimeMillis()
        val executionTime = endTime - startTime
        println("Tiempo de ejecución: $executionTime ms")
    }
}