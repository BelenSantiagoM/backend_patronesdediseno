package abstractFactory

class RestServiceImpl: IServiceStackAbstractFactory {
    override fun getEmployeeService(): IEmployeeService=EmployeeServiceRestImpl()

    override fun getProductsService(): IProductService = ProductServiceRestImpl()
}