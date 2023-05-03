package facade

class CRMSystem {
    fun findCustomer(customerId: Long?): Customer? {
        return OnMemoryDataBase().findCustomerById(customerId!!)
    }
}