package strategy

interface IAuthenticationStrategy {
    fun authenticate(userName: String?, passwrd: String?): Principal?
}

