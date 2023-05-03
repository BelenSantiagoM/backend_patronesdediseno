package proxy

class SecurityService {
    fun authorization(user: String, password: String): Boolean {
        return if (user == "lily" && password == "1234") {
            println("Usuario $user autorizado")
            true
        } else {
            println("Usuario $user NO autorizado")
            false
        }
    }
}