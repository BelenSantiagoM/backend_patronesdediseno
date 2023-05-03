package strategy

class AuthenticationProvider{
    private lateinit var authenticationStrategy: IAuthenticationStrategy

    fun setAuthenticationStrategy(strategy: IAuthenticationStrategy) {
        this.authenticationStrategy = strategy
    }

    fun authenticate(userName: String?, password: String?): Principal? {
        if (authenticationStrategy == null) {
            throw RuntimeException("Estrategia de autenticación no definida")
        }
        return authenticationStrategy.authenticate(userName, password)
    }
}
