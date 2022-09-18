package datastructures.graph

import datastructures.graph.implementation.EdgeType
import datastructures.graph.implementation.Vertex
import datastructures.graph.implementation.WeightedEdge

interface WeightedGraph<T> {

    fun createVertex(data: T): Vertex<T>

    fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double)

    fun edges(source: Vertex<T>): ArrayList<WeightedEdge<T>>

    fun weight(source: Vertex<T>, destination: Vertex<T>): Double

}

interface UnweightedGraph<T> {

    fun createVertex(data: T): Vertex<T>

    fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>)

    fun edges(source: Vertex<T>): ArrayList<Edge<T>>

}

interface Edge<T> {
    val from: Vertex<T>
    val to: Vertex<T>
}
