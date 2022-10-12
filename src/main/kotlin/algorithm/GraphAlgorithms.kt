package algorithm

import algorithm.util.GraphPath
import algorithm.util.PathTracker
import data.structure.graph.*
import exception.invalidArgumentError
import java.util.*

fun <T> Graph<T, out Edge<T>>.breadthFirstSearch(startVertex: Vertex<T>): ArrayList<Vertex<T>> {
    val queue = ArrayDeque<Vertex<T>>()
    val visited = arrayListOf<Vertex<T>>()

    queue.add(startVertex)

    while (queue.isNotEmpty()) {
        val currentVertex = queue.remove()

        if (!visited.contains(currentVertex)) visited.add(currentVertex)

        edges(currentVertex).forEach { edge ->
            if (!visited.contains(edge.to)) queue.add(edge.to)
        }
    }

    return visited
}

fun <T> Graph<T, out Edge<T>>.depthFirstSearch(startVertex: Vertex<T>): ArrayList<Vertex<T>> {
    val stack = ArrayDeque<Vertex<T>>()
    val visited = arrayListOf<Vertex<T>>()

    stack.push(startVertex)

    while (stack.isNotEmpty()) {
        val currentVertex = stack.peek()
        if (!visited.contains(currentVertex)) visited.add(currentVertex)

        val notVisitedNeighbor = edges(currentVertex).find { edge -> edge.to !in visited }?.to

        if (notVisitedNeighbor != null) {
            stack.push(notVisitedNeighbor)
        } else {
            stack.pop()
        }
    }

    return visited
}

fun <T> MutableGraph<T, out WeightedEdge<T>>.findShortestPath(from: Vertex<T>, to: Vertex<T>): GraphPath<T> {
    if (from == to) invalidArgumentError("From and To vertices are equals: ${from.data}")

    val queue = ArrayDeque<Vertex<T>>()
    val tracker = PathTracker(from)

    // push first vertex in both queue and tracker
    queue.add(from)

    while (queue.isNotEmpty()) {
        // get vertex from queue
        val currentVertex = queue.remove()

        // check all edges. If the edge is good enough, refresh path and push this edge to queue
        edges(currentVertex).forEach { edge ->
            val targetVertex = edge.to
            // potential new weight with new edge
            val newPathWeight = tracker.getPathWeight(edge.from) + edge.weight

            if (!tracker.isTracked(targetVertex) || newPathWeight < tracker.getPathWeight(targetVertex)) {
                tracker.addOrUpdatePathEdge(edge, newPathWeight)
                queue.add(targetVertex)
            }
        }
    }

    return tracker.collectPath(to)
}
