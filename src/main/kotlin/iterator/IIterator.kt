interface IIterator<T> {
    operator fun hasNext(): Boolean
    operator fun next(): T
}