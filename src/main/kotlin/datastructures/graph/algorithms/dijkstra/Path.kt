package datastructures.graph.algorithms.dijkstra

import datastructures.graph.implementation.WeightedEdge

@JvmInline
value class Path<T>(private val list: List<WeightedEdge<T>>) {

    fun weight() = list.sumOf { it.weight }

    override fun toString() =
        buildString {
            list.forEachIndexed { i, edge ->
                val pathPart = "${edge.from.data} --${edge.weight}-> "
                append(pathPart)
                if (i == list.lastIndex) {
                    append("${edge.to.data}\t")
                }
            }
        }

}