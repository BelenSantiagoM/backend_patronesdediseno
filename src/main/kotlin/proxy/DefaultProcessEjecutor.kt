package proxy

class DefaultProcessEjecutor : IProcessEjecutor {
    @Throws(Exception::class)
    override fun ejecuteProcess(idProcess: Int, user: String?, password: String?) {
        println("procesos $idProcess en ejecución")
        println("procesos $idProcess terminado")
    }
}