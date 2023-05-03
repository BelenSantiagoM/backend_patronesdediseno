package facade

import java.util.*


class BankSystem {

    @Throws(GeneralPaymentError::class)
    fun transfer(request: TransferRequest): String? {
        val cardNumerPrefix: String = request.getCardNumber()!!.substring(0, 3)
        if (!OnMemoryDataBase().validateCardBins(cardNumerPrefix)) {
            throw GeneralPaymentError("Tarjeta inválida.")
        }
        val cardCompany: String? = OnMemoryDataBase().getCardCompany(cardNumerPrefix)
        if ("AMEX" == cardCompany && request.getCardNumber()!!.length !== 15) {
            throw GeneralPaymentError("El número de la tarjeta es inválido")
        } else if (("VISA" == cardCompany || "MASTERCARD" == cardCompany)
            && request.getCardNumber()!!.length !== 16
        ) {
            throw GeneralPaymentError("El número de la tarjeta es inválido")
        }
        val number: String = request.getCardNumber()!!
        val cardNumerSubfix = number.substring(number.length - 4, number.length)
        System.out.println(
            (("Se ha realizado un cargo al cliente '"
                    + request.getCardName()) + "' \n"
                    + "\tpor el monto de '" + request.getAmmount()) + "' a la tarjeta "
                    + "terminación '" + cardNumerSubfix + "'.\n"
        )
        return UUID.randomUUID().toString()
    }
}