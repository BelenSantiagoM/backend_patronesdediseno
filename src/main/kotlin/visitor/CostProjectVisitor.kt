package visitor

class CostProjectVisitor : IVisitor<Number> {
    private var totalCost: Double = 0.0

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
        totalCost += employee.getPrice()
    }

    override fun getResult(): Number {
        return totalCost
    }
}
