package proxy

import proxy.ServiceFactory.createProcessEjecutor

object ProxyMain {
    @JvmStatic
    fun main(args: Array<String>) {
        val user = "lily"
        val password = "1234"
        val process = 1
        val processEjecutor = createProcessEjecutor()
        try {
            processEjecutor.ejecuteProcess(process, user, password)
        } catch (e: Exception) {
            println(e.message)
        }
    }
}