package module

class ModuleMessage(
    private val source: String,
    private val target: String,
    val messageType: String,
    private val payload: Any
) {
    // GETTERS
    fun getSource(): String {
        return source
    }

    fun getTarget(): String {
        return target
    }

    @JvmName("getMessageType1")
    fun getMessageType(): String {
        return messageType
    }

    fun getPayload(): Any {
        return payload
    }

}