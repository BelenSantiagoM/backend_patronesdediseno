package visitor

interface IVisitable {
    fun accept(visitor: IVisitor<*>)
}
