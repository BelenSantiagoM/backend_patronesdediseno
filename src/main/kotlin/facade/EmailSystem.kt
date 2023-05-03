package facade


class EmailSystem {
    fun sendEmail(values: Map<String?, String?>) {
        var templete = """
             
             **************************************
             |To: ${"$"}name
             |from: FacadeSystem
             |
             |Muchas gracias por utilizar el servicio en 
             |línea para realizar sus pagos.
             |
             |Hace un momento acabamos de recibir un pago:
             |
             |Monto del pago: ${"$"}ammount.
             |Nuevo Saldo: ${"$"}newBalance.
             |Tarjeta terminación: ${"$"}cardNumber
             |Referencia de pago: ${"$"}reference
             |Nuevos status: ${"$"}newStatus
             |
             |Gracias por su preferencia.
             |
             |Este correo no deberá ser contestado ya que 
             |ha sido enviado por un proceso automático
             **************************************
             """.trimIndent()
        for (str in values.keys) {
            templete = templete.replace(str!!, values[str]!!)
        }
        print(templete)
    }
}