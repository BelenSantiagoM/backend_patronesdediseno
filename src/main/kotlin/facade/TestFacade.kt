package facade

fun main() {
    val request = PaymentRequest()
    request.setAmmount(500.0)
    request.setCardExpDate("10/2015")
    request.setCardName("Oscar Blancarte")
    request.setCardNumber("1234567890123456")
    request.setCardSecureNum("345")
    request.setCustomerId(1L)

    try {
        val paymentFacade = OnlinePaymentFacadeImpl()
        paymentFacade.pay(request)
    } catch (e: Exception) {
        println(e.message)
    }

}