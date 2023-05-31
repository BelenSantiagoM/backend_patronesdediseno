package visitor

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "Responsible")
@XmlAccessorType(XmlAccessType.FIELD)
class Employee : IVisitable {

    @XmlAttribute(name = "name")
    private var name: String? = null

    @XmlAttribute(name = "price")
    private var price: Double = 0.0

    constructor() // Constructor por defecto para JAXB

    constructor(name: String, price: Double) {
        this.name = name
        this.price = price
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getPrice(): Double {
        return price
    }

    fun setPrice(price: Double) {
        this.price = price
    }

    override fun accept(visitor: IVisitor<*>) {
        visitor.employee(this)
    }

    override fun hashCode(): Int {
        var hash = 7
        hash = 37 * hash + name.hashCode()
        return hash
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val employee = other as Employee
        return name == employee.name
    }
}
