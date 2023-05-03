package composite

class SimpleProduct(name: String?, price: Double, protected var brand: String) :
        AbstractProduct(name!!, price) {
    /** GET and SET  */
}