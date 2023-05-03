package facade

class PaymentResponse {
    private var paymentConfirmNumber: String? = null
    private var newBalance = 0.0
    private var customerStatus: String? = null

    constructor(paymentConfirmNumber: String?, newBalance: Double, customerStatus: String?) {
        this.paymentConfirmNumber = paymentConfirmNumber
        this.newBalance = newBalance
        this.customerStatus = customerStatus
    }

    fun getPaymentConfirmNumber(): String? {
        return paymentConfirmNumber
    }

    fun setPaymentConfirmNumber(paymentConfirmNumber: String?) {
        this.paymentConfirmNumber = paymentConfirmNumber
    }

    fun getNewBalance(): Double {
        return newBalance
    }

    fun setNewBalance(newBalance: Double) {
        this.newBalance = newBalance
    }

    fun getCustomerStatus(): String? {
        return customerStatus
    }

    fun setCustomerStatus(customerStatus: String?) {
        this.customerStatus = customerStatus
    }
}