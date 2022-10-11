package data.structure.graph

import util.Table

class MutableGraph<T, E : Edge<T>> : Graph<T, E> {

    private val map: HashMap<Vertex<T>, ArrayList<E>> = HashMap()

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(map.count(), data)
        map[vertex] = ArrayList()
        return vertex
    }

    override fun addEdge(type: Edge.EdgeType, edge: E) {
        when (type) {
            Edge.EdgeType.DIRECTED -> addDirectedEdge(edge)
            Edge.EdgeType.UNDIRECTED -> {
                addDirectedEdge(edge)
                addDirectedEdge(edge.reversed() as E)
            }
        }
    }

    private fun addDirectedEdge(edge: E) {
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
