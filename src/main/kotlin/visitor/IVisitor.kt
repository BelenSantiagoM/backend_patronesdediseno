package visitor

interface IVisitor<T> {
    fun project(project: Project)
    fun activitie(activitie: Activitie)
    fun employee(employee: Employee)
    fun getResult(): T
}
