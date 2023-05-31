package state

abstract class AbstractServerState {
    abstract fun handleMessage(server: Server, message: String)
}