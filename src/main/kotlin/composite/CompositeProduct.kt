package composite

class CompositeProduct(name: String?) : AbstractProduct(name!!, 0.0) {
    private val products: MutableList<AbstractProduct> = ArrayList()
    override var price: Double
        get() {
            var price = 0.0
            for (child in products) {
                price += child.price
            }
            return price
        }
        set(price) {
            throw UnsupportedOperationException()
        }

    fun addProduct(product: AbstractProduct) {
        products.add(product)
    }

    fun removeProduct(product: AbstractProduct): Boolean {
        return products.remove(product)
    }
}