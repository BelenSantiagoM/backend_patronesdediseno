package facade

class PaymentRequest {
    private var customerId: Long? = null
    private var ammount = 0.0
    private var cardNumber: String? = null
    private var cardName: String? = null
    private var cardExpDate: String? = null
    private var cardSecureNum: String? = null

    fun PaymentRequest() {}

    fun getCustomerId(): Long? {
        return customerId
    }

    fun setCustomerId(customerId: Long?) {
        this.customerId = customerId
    }

    fun getAmmount(): Double {
        return ammount
    }

    fun setAmmount(ammount: Double) {
        this.ammount = ammount
    }

    fun getCardNumber(): String? {
        return cardNumber
    }

    fun setCardNumber(cardNumber: String?) {
        this.cardNumber = cardNumber
    }

    fun getCardName(): String? {
        return cardName
    }

    fun setCardName(cardName: String?) {
        this.cardName = cardName
    }

    fun getCardExpDate(): String? {
        return cardExpDate
    }

    fun setCardExpDate(cardExpDate: String?) {
        this.cardExpDate = cardExpDate
    }

    fun getCardSecureNum(): String? {
        return cardSecureNum
    }

    fun setCardSecureNum(cardSecureNum: String?) {
        this.cardSecureNum = cardSecureNum
    }

}