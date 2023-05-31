package visitor

class PriceProjectVisitor : IVisitor<Number> {
    private var totalPrice: Double = 0.0

    override fun project(project: Project) {
        for (act in project.getActivities()) {
            act.accept(this)
        }
    }

    override fun activitie(activitie: Activitie) {
        totalPrice += activitie.getPrice()
        for (act in activitie.getActivities()) {
            act.accept(this)
        }
    }

    override fun employee(employee: Employee) {
        // No es relevante para este Visitor
    }

    override fun getResult(): Number {
        return totalPrice
    }
}
