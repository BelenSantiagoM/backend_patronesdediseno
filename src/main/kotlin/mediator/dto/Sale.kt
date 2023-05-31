package dto

import java.util.ArrayList
open class Sale {

    private var productos: MutableList<Product> = ArrayList()

    fun getProductos(): List<Product> {
        return productos
    }

    fun addProduct(product: Product) {
        this.productos.add(product)
    }

    fun setProductos(productos: List<Product>) {
        this.productos = productos.toMutableList()
    }
}