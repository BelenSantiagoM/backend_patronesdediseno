package dto

class Product(private var name: String) {

    // GETTER
    fun getName(): String {
        return name
    }

    // SETTER
    fun setName(name: String) {
        this.name = name
    }
}