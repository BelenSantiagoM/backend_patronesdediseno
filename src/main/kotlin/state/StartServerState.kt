package state

class StartServerState(private val server: Server) : AbstractServerState() {
    init {
        server.messageProcess.start()
    }

    override fun handleMessage(server: Server, message: String) {
        val isSaturated = server.messageProcess.queueMessage(message)
        if (!isSaturated) {
            server.setState(SaturatedServerState(server))
        }
    }
}
