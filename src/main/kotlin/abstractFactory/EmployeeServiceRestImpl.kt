package abstractFactory

class EmployeeServiceRestImpl: IEmployeeService {
    private val employee = listOf("Juan Carlos", "Moises", "Sandra")

    override fun getEmployee(): List<String> {
        return this.employee
    }
}