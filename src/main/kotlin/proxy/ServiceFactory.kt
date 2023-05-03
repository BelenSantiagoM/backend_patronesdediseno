package proxy

object ServiceFactory {
    fun createProcessEjecutor(): IProcessEjecutor {
        return ProcessEjecutorProxy()
    }
}