package datastructures.graph.algorithms.dijkstra

import datastructures.graph.implementation.Vertex
import datastructures.graph.implementation.WeightedEdge
import utils.Table

class PathTracker<T>(private val visualize: Boolean = true) {

    // Table: Vertex | The Lowest weight on the current moment + optimal edge
    private val pathMap: HashMap<Vertex<T>, PathEdge<T>> = HashMap()

    // for start vertex
    fun initPath(vertex: Vertex<T>) {
        pathMap[vertex] = PathEdge(totalWeight = 0.0)
    }

    fun addOrUpdatePathEdge(edge: WeightedEdge<T>, weight: Double) {
        pathMap[edge.to] = PathEdge(edge, weight)

        if (visualize) printPathMap(pathMap[edge.to]!!)
    }

    fun hasLowerWeight(vertex: Vertex<T>, newWeight: Double) = newWeight < getPathWeight(vertex)

    fun isTracked(vertex: Vertex<T>) = pathMap[vertex] != null

    fun calculatePathWeight(vertex: Vertex<T>) = collectPath(vertex).weight()

    // dijkstra: backtrack path from finish to start
    fun collectPath(vertex: Vertex<T>): Path<T> {
        val path = arrayListOf<WeightedEdge<T>>()
        var pathEdge = pathMap[vertex] ?: error(NO_PATH_ERROR)

        while (!pathEdge.isStartEdge()) {
            val edge = pathEdge.edge!!

            path.add(edge)
            pathEdge = pathMap[edge.from] ?: error(PATH_EDGE_IS_NULL_ERROR)
        }

        return Path(path.reversed())
    }

    // prim: collectSpanningTree


    private fun getPathWeight(vertex: Vertex<T>) = pathMap[vertex]?.totalWeight ?: error(PATH_EDGE_IS_NULL_ERROR)

    private fun printPathMap(updatedPathEdge: PathEdge<T>) {
        val tableData = pathMap.toSortedMap { it1, it2 -> it1.index - it2.index }.map { (key, value) ->
            val mark = when {
                value.isStartEdge() -> "*"
                value == updatedPathEdge -> ">"
                else -> ""
            }
            listOf(mark + key.data, value.totalWeight.toString(), value.edge?.to?.let { collectPath(it) }.toString())
        }
        println(Table(columnNames = arrayListOf("Vertex", "TotalWeight", "Path"), data = tableData))
    }

    companion object {
        const val PATH_EDGE_IS_NULL_ERROR = "PathEdge is null unexpectedly"
        const val NO_PATH_ERROR = "There is no path between these vertices"
    }

    private data class PathEdge<T>(
        val edge: WeightedEdge<T>? = null,
        val totalWeight: Double
    ) {
        fun isStartEdge() = edge == null
    }
}
