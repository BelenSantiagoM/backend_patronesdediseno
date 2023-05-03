package strategy

class OnMemoryDataBase {
    val USER_MAP = hashMapOf<String, User>(
            "oblancarte" to User("oblancarte", "1234", "Admin"),
            "rlopez" to User("rlopez", "2345", "Cajero"),
            "lcastro" to User("lcastro", "2345", "Supervisor")
    )
    fun findUserByName(name: String): User? {
        return USER_MAP[name]
    }
}