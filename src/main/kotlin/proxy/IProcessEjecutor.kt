package proxy

interface IProcessEjecutor {
    @Throws(Exception::class)
    fun ejecuteProcess(idProcess: Int, user: String?, password: String?)
}