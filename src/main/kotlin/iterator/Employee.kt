package iterator

import IIterator
import java.util.*

class Employee(var name: String, var puesto: String, vararg subordinates: Employee?) : IContainer<Employee?> {
    var role: String = ""
    private var subordinates: MutableList<Employee?>

    init {
        this.role = puesto  // initialize role property
        this.subordinates = Arrays.asList(*subordinates)
    }


    override fun createIterator(): IIterator<Employee?>? {
        return TreeEmployeeIterator()
    }

    inner class TreeEmployeeIterator : IIterator<Employee?> {
        private val list = LinkedList<Employee?>()
        private var index = 0

        init {
            addRecursive(this@Employee)
        }

        fun addRecursive(employee: Employee?) {
            list.add(employee)
            if (employee!!.getSubordinates() != null) {
                for (subordinate in employee.getSubordinates()!!) {
                    addRecursive(subordinate)
                }
            }
        }

        override operator fun hasNext(): Boolean {
            return if (list.isEmpty()) {
                false
            } else index < list.size
        }

        override operator fun next(): Employee? {
            if (!hasNext()) {
                throw RuntimeException("there are no more elements")
            }
            return list[index++]
        }
    }

    fun getSubordinates(): List<Employee?>? {
        return subordinates
    }

    fun setSubordinates(subordinates: MutableList<Employee?>) {
        this.subordinates = subordinates
    }

    fun addSubordinate(subordinate: Employee?) {
        if (subordinate == null) {
            subordinates = ArrayList()
        }
        subordinates.add(subordinate)
    }

    override fun toString(): String {
        return "Employee{name=$name, role=$role}"
    }
}