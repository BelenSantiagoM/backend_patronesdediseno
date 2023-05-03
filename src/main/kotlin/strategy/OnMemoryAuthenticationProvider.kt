package strategy

class OnMemoryAuthenticationProvider : IAuthenticationStrategy {
    override fun authenticate(userName: String?, passwrd: String?): Principal? {
        val user: User? = OnMemoryDataBase().findUserByName(userName!!)
        return if ((user != null) && (user.getPassword() == passwrd)) {
            Principal(user.getUserName(), user.getRol())
        } else null
    }
}