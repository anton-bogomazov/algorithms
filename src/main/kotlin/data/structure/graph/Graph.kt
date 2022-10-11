package data.structure.graph


interface Graph<T, E : Edge<T>> {

    fun createVertex(data: T): Vertex<T>

    fun addEdge(type: Edge.EdgeType, edge: E)

    fun edges(source: Vertex<T>): ArrayList<E>

}

data class Vertex<T>(val index: Int, val data: T)

open class Edge<T>(
    open val from: Vertex<T>,
    open val to: Vertex<T>
) {
    enum class EdgeType {
        DIRECTED,
        UNDIRECTED
    }

    open fun reversed() = Edge(from = to, to = from)
    override fun toString() = to.data.toString()
}

class WeightedEdge<T>(
    from: Vertex<T>,
    to: Vertex<T>,
    val weight: Double
) : Edge<T>(from, to) {

    override fun reversed() = WeightedEdge(from = to, to = from, weight = weight)

    override fun toString() = super.toString() + "<$weight>"

}
