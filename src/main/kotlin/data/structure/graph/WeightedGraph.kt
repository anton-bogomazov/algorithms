package data.structure.graph

import util.Table

class WeightedGraph<T> : Graph<T, WeightedEdge<T>> {

    private val map: HashMap<Vertex<T>, ArrayList<WeightedEdge<T>>> = HashMap()

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(map.count(), data)
        map[vertex] = ArrayList()
        return vertex
    }

    override fun addEdge(type: Edge.EdgeType, edge: WeightedEdge<T>) {
        when (type) {
            Edge.EdgeType.DIRECTED -> addDirectedEdge(edge)
            Edge.EdgeType.UNDIRECTED -> {
                addDirectedEdge(edge)
                addDirectedEdge(edge.reversed())
            }
        }
    }

    private fun addDirectedEdge(edge: WeightedEdge<T>) {
        map[edge.to] ?: error("${edge.to} not found in this graph")

        map[edge.from]?.add(edge) ?: error("${edge.from} not found in this graph")
    }

    override fun edges(source: Vertex<T>) = map[source] ?: arrayListOf()

    override fun toString(): String {
        val content = map.map { (vertex, edges) ->
            listOf(vertex.index.toString(), vertex.data.toString(), edges.joinToString { it.toString() })
        }.sortedBy { it.first() }
        return Table(data = content, columnNames = listOf("Index", "Source", "Destinations")).toString()
    }

}
