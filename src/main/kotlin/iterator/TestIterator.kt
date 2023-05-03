import iterator.Employee

object TestIterator {
    @JvmStatic
    fun main(args: Array<String>) {
        val employee = Employee(
            "Juan", "CEO",
            Employee(
                "Pedro", "President",
                Employee(
                    "Liliana", "VP",
                    Employee(
                        "Oscar", "Manager",
                        Employee("Mario", "Developer"),
                        Employee("Rodolfo", "Developer")
                    ),
                    Employee(
                        "Sofia", "Manager",
                        Employee("Adrian", "Sr Developer"),
                        Employee("Rebeca", "Developer")
                    )
                )
            )
        )
        val empIterator: IIterator<Employee?>? = employee.createIterator()
        while (empIterator?.hasNext() == true) {
            val emp: Employee? = empIterator.next()
            println("emp > $emp")
        }
    }
}