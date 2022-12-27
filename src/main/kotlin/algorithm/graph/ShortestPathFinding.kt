package algorithm.graph

import data.structure.graph.Vertex
import data.structure.graph.WeightedGraph
import exception.invalidArgumentError
import java.util.*

fun <T> WeightedGraph<T>.findShortestPath(from: Vertex<T>, to: Vertex<T>): Double {
    if (from == to) invalidArgumentError("From and To vertices are equals: ${from.data}")

    val map = hashMapOf<Vertex<T>, Double>()
    val queue = ArrayDeque<Vertex<T>>()
    // could be replaced by map vertex to pathWeight
    map[from] = 0.00

    // push first vertex in queue and map
    queue.add(from)

    while (queue.isNotEmpty()) {
        // get vertex from queue
        val currentVertex = queue.remove()

        // check all edges. If the edge is good enough, refresh path and push this edge to queue
        edges(currentVertex).forEach { edge ->
            val targetVertex = edge.to
            // potential new weight with new edge
            val newPathWeight = map[edge.from]!! + edge.weight

            if (!map.contains(targetVertex) || newPathWeight < map[targetVertex]!!) {
                map[edge.to] = newPathWeight
                queue.add(targetVertex)
            }
        }
    }

    return map[to]!!
}
