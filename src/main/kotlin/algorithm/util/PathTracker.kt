package algorithm.util

import data.structure.graph.Vertex
import data.structure.graph.WeightedEdge
import exception.noSolutionError
import util.Table

class PathTracker<T>(startVertex: Vertex<T>, private val visualize: Boolean = false) {

    // Table: Vertex | The Lowest weight on the current moment + optimal edge
    private val pathMap = mutableMapOf<Vertex<T>, PathEdge<T>>(startVertex to PathEdge(totalWeight = 0.0))

    fun addOrUpdatePathEdge(edge: WeightedEdge<T>, weight: Double) {
        pathMap[edge.to] = PathEdge(edge, weight)

        if (visualize) print(pathMap[edge.to]!!)
    }

    fun isTracked(vertex: Vertex<T>) = pathMap[vertex] != null

    fun getPathWeight(vertex: Vertex<T>) = pathMap[vertex]?.totalWeight ?: collectPath(vertex).weight()

    // backtrack path from finish to start
    fun collectPath(vertex: Vertex<T>): GraphPath<T> {
        val path = arrayListOf<WeightedEdge<T>>()
        var pathEdge = pathMap[vertex] ?: noSolutionError()

        while (!pathEdge.isStartEdge()) {
            val edge = pathEdge.edge!!

            path.add(edge)
            pathEdge = pathMap[edge.from]!!
        }

        return GraphPath(path.reversed())
    }

    private fun print(updatedPathEdge: PathEdge<T>): String {
        val tableData = pathMap.toSortedMap { it1, it2 -> it1.index - it2.index }.map { (key, value) ->
            val mark = when {
                value.isStartEdge() -> "*"
                value == updatedPathEdge -> ">"
                else -> ""
            }
            listOf(mark + key.data, value.totalWeight.toString(), value.edge?.to?.let { collectPath(it) }.toString())
        }
        return Table(columnNames = arrayListOf("Vertex", "TotalWeight", "Path"), data = tableData).toString()
    }

}

private data class PathEdge<T>(
    val edge: WeightedEdge<T>? = null,
    val totalWeight: Double
) {
    fun isStartEdge() = edge == null
}
