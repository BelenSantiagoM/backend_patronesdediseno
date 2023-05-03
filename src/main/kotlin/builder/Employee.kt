package builder

class Employee {
    private lateinit var name: String
    private var  age: Int =0
    private lateinit var  gender: String
    private lateinit var  address: Address
    private lateinit var  phones: List<Phone>
    private lateinit var contacts: List<Contact>

    private constructor(
            name: String?, age: Int, gender: String?, address: Address?,
            phones: List<Phone>, contacts: List<Contact>
    ) {
        this.name = name!!
        this.age = age
        this.gender = gender!!
        this.address = address!!
        this.phones = phones
        this.contacts = contacts
    }

    constructor(name: String, age: Int, gender: String) {
        this.name = name
        this.age = age
        this.gender = gender
    }

    constructor()


    override fun toString(): String {
        return  "name: " + this.name + ", age: " + this.age + ", gender: " + this.gender + ", address: " + this.address +
                "phones: " + this.phones + ", contacts: " +  this.contacts
    }
    class EmployeeBuilder : IBuilder<Employee> {
        private var name: String? = null
        private var age = 0
        private var gender: String? = null
        private var _address: Address? = null
        private val phones: MutableList<Phone> = ArrayList<Phone>()
        private val contacts: MutableList<Contact> = ArrayList<Contact>()
        fun setName(name: String?): EmployeeBuilder {
            this.name = name
            return this
        }

        fun setAge(age: Int): EmployeeBuilder {
            this.age = age
            return this
        }

        fun setGender(gender: String?): EmployeeBuilder {
            this.gender = gender
            return this
        }

        fun setAddress(
                address: String?, city: String?,
                country: String?, cp: String?
        ): EmployeeBuilder {
            _address = Address(address, city, country, cp)
            return this
        }

        fun addPhones(
                phoneNumber: String?, ext: String?,
                phoneType: String?
        ): EmployeeBuilder {
            phones.add(Phone(phoneNumber, ext, phoneType))
            return this
        }

        fun addContacts(
                name: String?, phoneNumber: String?,
                ext: String?, phoneType: String?, address: String?, city: String?,
                country: String?, cp: String?
        ): EmployeeBuilder {
            contacts.add(
                    Contact(
                            name, Phone(phoneNumber, ext, phoneType), Address(address, city, country, cp)
                    )
            )
            return this
        }

        fun addContacts(
                name: String?, phoneNumber: String?,
                ext: String?, phoneType: String?
        ): EmployeeBuilder {
            contacts.add(Contact(name=name, phone =  Phone(phoneNumber, ext, phoneType), address = null))
            return this
        }

        override fun  build(): Employee {
            return Employee(name, age, gender, _address, phones, contacts = contacts)
        }
    }
}