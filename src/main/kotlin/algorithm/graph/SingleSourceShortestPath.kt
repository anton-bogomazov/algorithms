package algorithm.graph

import data.structure.container.graph.Vertex
import data.structure.container.graph.WeightedGraph

// Bellman–Ford Algorithm
// Compute the shortest paths from a single source vertex
// to all the other vertices in a given weighted digraph.
// Slower than Dijkstra’s Algorithm, but it can handle negative weights.
// Worst case complexity time/space: O(v*e)/O(v)
fun <T> findSSShortestPath(graph: WeightedGraph<T>, source: Vertex<T>): Map<Vertex<T>, Int> {
    val distances = mutableMapOf<Vertex<T>, Int>()
    val predecessor = mutableMapOf<Vertex<T>, Vertex<T>?>()

    // initialize distances and predecessors
    for (vertex in graph.vertices()) {
        distances[vertex] = if (vertex == source) 0 else Int.MAX_VALUE
        predecessor[vertex] = null
    }

    // perform relaxation step |V| - 1 times
    for (i in 1..graph.vertices().lastIndex) {
        for (edge in graph.edges()) {
            val u = edge.from
            val v = edge.to
            val weight = edge.weight
            if (distances[u]!! + weight < distances[v]!!) {
                distances[v] = distances[u]!! + weight.toInt()
                predecessor[v] = u
            }
        }
    }

    // check for negative weight cycles
    for (edge in graph.edges()) {
        val u = edge.from
        val v = edge.to
        val weight = edge.weight
        if (distances[u]!! + weight < distances[v]!!) {
            throw IllegalArgumentException("Graph contains a negative weight cycle")
        }
    }

    return distances
}
