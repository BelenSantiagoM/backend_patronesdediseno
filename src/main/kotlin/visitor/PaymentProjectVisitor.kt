package visitor

class PaymentProjectVisitor : IVisitor<MutableList<EmployeePay>> {
    private var employeePayment = HashMap<String?, Number?>()

    override fun project(project: Project) {
        for (act in project.getActivities()) {
            act.accept(this)
        }
    }

    override fun activitie(activitie: Activitie) {
        activitie.getResponsible()?.accept(this)
        for (act in activitie.getActivities()) {
            act.accept(this)
        }
    }

    override fun employee(employee: Employee) {
        val resp = employee.getName()
        val currentPayment = employeePayment[resp]
        if (currentPayment != null) {
            employeePayment[resp] =
                currentPayment.toDouble() + employee.getPrice()
        } else {
            employeePayment[resp] = employee.getPrice()
        }
    }

    override fun getResult(): MutableList<EmployeePay> {
        val response = ArrayList<EmployeePay>()

        val keys = employeePayment.keys
        for (key in keys) {
            response.add(EmployeePay(key!!, employeePayment[key]!!.toDouble()))
        }

        return response
    }
}
