package algorithm.graph

import data.structure.container.graph.WeightedGraph
import data.structure.container.set.DisjointSet

// Detect a cycle in graph.
// Worst case complexity time/space: O(n)/O(n)
fun <T> hasCycle(graph: WeightedGraph<T>): Boolean {
    // create a disjoint set for each vertex in the graph
    val disjointSet = DisjointSet(graph.vertices().toTypedArray())

    // iterate through all the edges in the graph
    for (edge in graph.edges()) {
        // find the root nodes for the source and destination vertices
        val sourceRoot = disjointSet.find(edge.from)
        val destRoot = disjointSet.find(edge.to)

        // if the root nodes are the same, it means there is a cycle
        if (sourceRoot == destRoot) return true

        // otherwise, union the two sets together
        disjointSet.union(sourceRoot, destRoot)
    }

    // if we have iterated through all the edges and haven't found a cycle, return false
    return false
}
