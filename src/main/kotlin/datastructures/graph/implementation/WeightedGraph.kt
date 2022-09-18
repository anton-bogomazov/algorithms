package datastructures.graph.implementation

import datastructures.graph.Edge

data class Vertex<T>(val index: Int, val data: T)

data class WeightedEdge<T>(
    override val from: Vertex<T>,
    override val to: Vertex<T>,
    val weight: Double
) : Edge<T>

data class UnweightedEdge<T>(
    override val from: Vertex<T>,
    override val to: Vertex<T>
) : Edge<T>

enum class EdgeType {
    DIRECTED,
    UNDIRECTED
}