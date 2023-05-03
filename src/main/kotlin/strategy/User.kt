package strategy

class User {
    private var userName: String = ""
    private var password: String= ""
    private var rol: String = ""

    constructor(userName: String, password: String, rol: String) {
        this.userName = userName
        this.password = password
        this.rol = rol
    }

    fun getUserName(): String {
        return this.userName
    }

    fun getRol(): String {
        return this.rol
    }

    fun getPassword(): String {
        return this.password
    }
}