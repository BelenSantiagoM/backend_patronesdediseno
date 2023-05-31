package state

class StopServerState(server: Server) : AbstractServerState() {
    init {
        server.messageProcess.stop()
    }

    override fun handleMessage(server: Server, message: String) {
        println("The server is stopped")
    }
}