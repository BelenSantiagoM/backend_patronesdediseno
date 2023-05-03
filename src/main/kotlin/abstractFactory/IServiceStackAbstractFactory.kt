package abstractFactory

interface IServiceStackAbstractFactory {
    fun getEmployeeService(): IEmployeeService
    fun getProductsService(): IProductService
}