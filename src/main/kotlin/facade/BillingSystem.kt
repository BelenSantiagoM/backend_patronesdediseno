package facade

class BillingSystem {
    fun queryCustomerBalance(customerId: Long): Double {
        val customer: Customer? = OnMemoryDataBase().findCustomerById(customerId)
        return customer!!.getBalance()
    }
    fun pay(billingPay: BillingPayRequest): Double {
        val customer: Customer? = OnMemoryDataBase().findCustomerById(billingPay.getCustomerId()!!)
        customer!!.setBalance(customer.getBalance() - billingPay.getAmount())
        System.out.println(
            ("Pago aplicado al cliente '" + customer.getName() + "', "
                    + "el nuevo saldo es '" + customer.getBalance()) + "'"
        )
        return customer.getBalance() //new Balance.
    }
}