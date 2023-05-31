package state

class SaturatedServerState(private val server: Server) : AbstractServerState() {
    private var monitoringThread: Thread? = null

    init {
        server.messageProcess.start()
        monitoringThread = Thread {
            try {
                while (true) {
                    if (server.messageProcess.countMessage() < server.maxRequest) {
                        server.setState(StartServerState(server))
                        break
                    }
                }
            } catch (e: Exception) {
                println(e.message)
            }
        }
        monitoringThread?.start()
    }

    override fun handleMessage(server: Server, message: String) {
        println("Can't process request, Server Saturated")
    }
}
