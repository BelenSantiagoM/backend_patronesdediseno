package state

class Server {
    var maxRequest = 5
    var messageProcess = MessageProcess(this)
    private var state: AbstractServerState? = null

    init {
        setState(StopServerState(this))
    }

    fun handleMessage(message: String) {
        state!!.handleMessage(this, message)
    }


    fun getState(): AbstractServerState {
        return state!!
    }

    fun setState(state: AbstractServerState) {
        if (this.state is StartingServerState && state is StopServerState) {
            println("Server is starting, cannot change state")
            return
        }
        this.state = state
        println("Server change state > ${this.state!!::class.simpleName}")
    }
}
