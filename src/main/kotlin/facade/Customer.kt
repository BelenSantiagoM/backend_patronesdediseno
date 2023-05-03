package facade

class Customer {
    private var id: Long? = null
    private var name: String? = null
    private var balance = 0.0
    private var status: String? = null

    constructor(id: Long?, name: String?, balance: Double, status: String?) {
        this.id = id
        this.name = name
        this.balance = balance
        this.status = status
    }

    fun getId(): Long? {
        return id
    }

    fun setId(id: Long?) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getBalance(): Double {
        return balance
    }

    fun setBalance(balance: Double) {
        this.balance = balance
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String?) {
        this.status = status
    }

    override fun toString(): String {
        return """
             Customer{id=$id, name=$name, 
             balance=$balance, status=$status}
             """.trimIndent()
    }

}
