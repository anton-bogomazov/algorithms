package algorithm.graph

import data.structure.container.graph.Vertex
import data.structure.container.graph.WeightedGraph


// Kahn’s Topological Sort Algorithm
// Traverse given graph in topological order.
// Topological order of a DAG is a linear arrangement of the vertices
// in the graph such that all edges go from left to right.
// Worst case complexity time/space: O(v*e)/O(v)
fun <T> topologicalSort(graph: WeightedGraph<T>): List<Vertex<T>> {
    val sortedVertices = mutableListOf<Vertex<T>>()
    val inDegree = graph.vertices().associateWith { graph.inDegree(it) }.toMutableMap()

    // Find all the vertices with no incoming edges
    val sources = graph.vertices().filter { inDegree[it] == 0 }.toMutableList()

    while (sources.isNotEmpty()) {
        val vertex = sources.removeAt(0)
        sortedVertices.add(vertex)

        // Decrement the in-degree of each of the vertex's neighbors
        graph.edges(vertex).forEach {
            val neighbor = it.to
            inDegree[neighbor] = inDegree[neighbor]!! - 1

            // If the neighbor has no more incoming edges, add it to the sources list
            if (inDegree[neighbor] == 0) {
                sources.add(neighbor)
            }
        }
    }

    // If there are any vertices left with non-zero in-degree, there is a cycle in the graph
    if (inDegree.values.any { it > 0 }) {
        throw IllegalArgumentException("The graph contains a cycle")
    }

    return sortedVertices
}

private fun <T> WeightedGraph<T>.inDegree(vertex: Vertex<T>) =
    edges().count { it.to == vertex }
