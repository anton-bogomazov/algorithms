package data.structure.primitive

data class Node<T>(val data: T) {
    var next: Node<T>? = null
}
