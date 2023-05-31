package visitor

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "Project")
@XmlAccessorType(XmlAccessType.FIELD)
class Project : IVisitable {

    @XmlAttribute(name = "name")
    private var name: String? = null

    @XmlElement(name = "Activities")
    private var activities: MutableList<Activitie>? = null

    constructor() // Constructor por defecto para JAXB

    constructor(name: String) {
        this.name = name
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getActivities(): MutableList<Activitie> {
        if (activities == null) {
            activities = ArrayList()
        }
        return activities as MutableList<Activitie>
    }

    fun setActivities(activities: MutableList<Activitie>) {
        this.activities = activities
    }

    override fun accept(visitor: IVisitor<*>) {
        visitor.project(this)
    }
}
