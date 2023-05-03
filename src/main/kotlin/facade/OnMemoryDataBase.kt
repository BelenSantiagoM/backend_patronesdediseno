package facade


class OnMemoryDataBase {
    private val CUSTOMER_MAP = HashMap<Long, Customer>()
    private val CARD_BINS = HashMap<String, Card>()

    init {
        CUSTOMER_MAP[1L] = Customer(1L, "Oscar Blancarte", 500.0, "Discontinued")
        CUSTOMER_MAP[2L] = Customer(2L, "Juan Perez", 300.0, "Discontinued")
        CUSTOMER_MAP[3L] = Customer(3L, "Adrian Lopez", 100.0, "Active")
        CUSTOMER_MAP[4L] = Customer(4L, "Melisa Mares", 100.0, "Inactive")

        CARD_BINS["123"] = Card("123", "VISA", "Credit")
        CARD_BINS["234"] = Card("234", "MASTERCARD", "Debit")
        CARD_BINS["345"] = Card("345", "AMEX", "Credit")
    }

    fun findCustomerById(id: Long): Customer? {
        return CUSTOMER_MAP[id]
    }

    fun changeCustomerStatus(id: Long, newStatus: String) {
        val customer = findCustomerById(id)
        customer!!.setStatus(newStatus)
        println(
            "Change of client status '" + customer.getName()
                    + "'" + newStatus
        )
    }

    fun validateCardBins(creditCardPrefix: String): Boolean {
        if (CARD_BINS.containsKey(creditCardPrefix)) {
            val company = CARD_BINS[creditCardPrefix]!!.getCompany()
            println(
                ("Valid card > '" + creditCardPrefix + "', "
                        + company + "\n")
            )
            return true
        } else {
            println("Invalid card >\n")
            return false
        }
    }

    fun getCardCompany(creditCardPrefix: String): String? {
        if (CARD_BINS.containsKey(creditCardPrefix)) {
            return CARD_BINS[creditCardPrefix]!!.getCompany()
        }
        throw RuntimeException("Card does not exist")
    }
}