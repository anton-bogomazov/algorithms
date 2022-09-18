package datastructures.graph.implementation

import datastructures.graph.WeightedGraph

class AdjacencyList<T> : WeightedGraph<T> {

    private val adjacencies: HashMap<Vertex<T>, ArrayList<WeightedEdge<T>>> = HashMap()

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(adjacencies.count(), data)
        adjacencies[vertex] = ArrayList()
        return vertex
    }

    override fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double) {
        when (edge) {
            EdgeType.DIRECTED -> addDirectedEdge(source, destination, weight)
            EdgeType.UNDIRECTED -> addUndirectedEdge(source, destination, weight)
        }
    }

    private fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double) {
        val edge = WeightedEdge(source, destination, weight)
        adjacencies[source]?.add(edge) ?: error("$source not found in this graph")
    }

    private fun addUndirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double) {
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }

    override fun edges(source: Vertex<T>) = adjacencies[source] ?: arrayListOf()

    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double =
        edges(source).firstOrNull { it.to == destination }?.weight ?: 0.0

    override fun toString(): String {
        return buildString {
            adjacencies.forEach { (vertex, edges) ->
                val edgeString = edges.joinToString { "${it.to.data.toString()}<${it.weight}>" }
                append("${vertex.data} ----> [ $edgeString ]\n")
            }
        }
    }

}
