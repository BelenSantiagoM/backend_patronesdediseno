package facade


class OnlinePaymentFacadeImpl{
    private val crmSystem = CRMSystem()
    private val billingSyste = BillingSystem()
    private val bankSyste = BankSystem()
    private val emailSenderSystem = EmailSystem()


    @Throws(GeneralPaymentError::class)
    fun pay(request: PaymentRequest): PaymentResponse {
        val customer = crmSystem.findCustomer(request.getCustomerId())
        //Validate Set
        if (customer == null) {
            throw GeneralPaymentError(
                ("Customer ID does not exist '"
                        + request.getCustomerId()) + "' not exist."
            )
        } else if (("Inactive" == customer.getStatus())) {
            throw GeneralPaymentError(
                (("Customer ID does not exist '"
                        + request.getCustomerId()).toString() + "' is inactive.")
            )
        } else if (request.getAmmount() >
            billingSyste.queryCustomerBalance(customer.getId()!!)
        ) {
            throw GeneralPaymentError(
                ("You are trying to make a payment "
                        + "\n\tgreater than the customer's balance")
            )
        }

        //charge to the card
        val transfer = TransferRequest(
            request.getAmmount(), request.getCardNumber(),
            request.getCardName(), request.getCardExpDate(),
            request.getCardNumber()
        )
        val payReference = bankSyste.transfer(transfer)

        //Impact of the balance in the billing system
        val billingRequest = BillingPayRequest(
            request.getCustomerId()!!, request.getAmmount()
        )
        val newBalance = billingSyste.pay(billingRequest)

        //The client is reactivated if the new balance is less than $ 51
        var newStatus = customer.getStatus()
        if (newBalance <= 50) {
            OnMemoryDataBase().changeCustomerStatus(request.getCustomerId()!!, "Active")
            newStatus = "Active"
        }

        //Envio de la confirmación de pago por Email.
        val params = HashMap<String?, String?>()
        params["\$name"] = customer.getName()
        params["\$ammount"] = request.getAmmount().toString()
        params["\$newBalance"] = newBalance.toString()
        val number: String = request.getCardNumber()!!
        val subfix = number.substring(number.length - 4, number.length)
        params["\$cardNumber"] = subfix
        params["\$reference"] = payReference
        params["\$newStatus"] = newStatus
        emailSenderSystem.sendEmail(params)
        return PaymentResponse(payReference, newBalance, newStatus)
    }
}
