package algorithm.graph

import data.structure.graph.WeightedEdge
import data.structure.graph.WeightedGraph
import data.structure.set.DisjointSet

// Kruskal’s Algorithm
// Find a minimum spanning tree for graph.
// Minimum Spanning Tree connects all the vertices with minimal total weighting for its edges.
// Worst case complexity time/space: O(n2)/O(1)
fun <T> minimumSpanningTree(graph: WeightedGraph<T>): List<WeightedEdge<T>> {
    val result = mutableListOf<WeightedEdge<T>>()
    val disjointSet = DisjointSet(graph.vertices().toTypedArray())

    // sort all the edges in the graph in non-decreasing order of their weight
    val edges = graph.edges().sortedBy { it.weight }

    for (edge in edges) {
        // find the root nodes for the source and destination vertices
        val sourceRoot = disjointSet.find(edge.from)
        val destRoot = disjointSet.find(edge.to)

        // if the root nodes are different, it means the edge does not form a cycle
        if (sourceRoot != destRoot) {
            // include the edge in the minimum spanning tree
            result.add(edge)
            // union the two sets together
            disjointSet.union(sourceRoot, destRoot)
        }
    }

    return result
}
