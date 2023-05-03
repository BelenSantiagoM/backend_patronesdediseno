package strategy

import factorymethod.MySqlDBAdapter
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement


class SQLAuthenticationProvider : IAuthenticationStrategy {
    val USER_QUERY = "SELECT userName,rol FROM users WHERE userName='%s' AND password = '%s'"
    var mysqlAdapter: MySqlDBAdapter? = null

    init {
        mysqlAdapter = MySqlDBAdapter()
    }
    override fun authenticate(userName: String?, passwrd: String?): Principal? {
        return try {
            val connection: Connection? = mysqlAdapter?.getConnection()
            val statement: Statement = connection!!.createStatement()
            val queryUser = String.format(USER_QUERY, userName, passwrd)
            val query: ResultSet = statement.executeQuery(queryUser)
            while (query.next()) {
                return Principal(
                        query.getString("userName"),
                        query.getString("rol")
                )
            }
            null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}