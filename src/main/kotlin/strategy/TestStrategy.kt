package strategy

import kotlin.system.exitProcess


object StrategyMain {
    private val authProvider: AuthenticationProvider = AuthenticationProvider()
    @JvmStatic
    fun main(args: Array<String>) {
        changeAuthenticationStrategy()
        var principal: Principal? = null
        do {
            println("\n\nPlease authenticate:")
            println("User:")
            val userName: String = readln()
            println("Password:")
            val password: String = readln()
            principal = authProvider.authenticate(userName, password)
            if (principal == null) {
                println("User or password invalid.")
                println("Do you want to change the authentication method? (S/N)")
                val op: String = readln()
                if (op.equals("S", ignoreCase = true)) {
                    changeAuthenticationStrategy()
                }
            }
        } while (principal == null)
        println("Successful authentication")
        println(principal)
    }

    private fun changeAuthenticationStrategy() {
        println("Enter the type of authentication to use.")
        println("1.-OnMemory Authentication")
        println("2.-SQL Authentication")
        println("3.-XML Authentication")
        val op: Int = readln().toInt()
        when (op) {
            1 -> {
                authProvider.setAuthenticationStrategy(
                        OnMemoryAuthenticationProvider()
                )
                println("OnMemory Authentication Select >")
            }

            2 -> {
                authProvider.setAuthenticationStrategy(
                        SQLAuthenticationProvider()
                )
                println("SQL Authentication Select >")
            }

            3 -> {
                authProvider.setAuthenticationStrategy(
                        XMLAuthenticationProvider()
                )
                println("XML Authentication Select >")
            }

            else -> {
                println("Invalid option")
                exitProcess(1)
            }
        }
    }
}