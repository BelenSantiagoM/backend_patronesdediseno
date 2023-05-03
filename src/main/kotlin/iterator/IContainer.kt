package iterator

import IIterator
import java.util.*

interface IContainer<T> {
    fun createIterator(): IIterator<T>?
}
