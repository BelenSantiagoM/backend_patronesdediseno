package proxy

class ProcessEjecutorProxy : IProcessEjecutor {
    @Throws(Exception::class)
    override fun ejecuteProcess(idProcess: Int, user: String?, password: String?) {
        val securityService = SecurityService()
        if (!securityService.authorization(user!!, password!!)) {
            throw Exception(
                "El usuario '" + user
                        + "' no tiene privilegios para ejecutar el proceso"
            )
        }
        val ejecutorProcess = DefaultProcessEjecutor()
        ejecutorProcess.ejecuteProcess(idProcess, user, password)
        val audit = AuditService()
        audit.auditServiceUsed(user, DefaultProcessEjecutor::class.java.name)
    }
}