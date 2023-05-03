package facade

interface IPaymentFacade {
    @Throws(GeneralPaymentError::class)
    fun pay(paymentRequest: PaymentRequest?): PaymentResponse?
}