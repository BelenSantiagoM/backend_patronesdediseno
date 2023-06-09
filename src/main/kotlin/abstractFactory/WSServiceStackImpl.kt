package abstractFactory

class WSServiceStackImpl: IServiceStackAbstractFactory {
    override fun getEmployeeService(): IEmployeeService = EmployeeServiceWSImpl()
    override fun getProductsService(): IProductService = ProductServiceWSImpl()
}