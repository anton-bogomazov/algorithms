package algorithm

import algorithm.util.GraphPath
import algorithm.util.PathTracker
import data.structure.graph.*
import exception.invalidArgumentError
import java.util.*

fun <T> Graph<T, out Edge<T>>.breadthFirstSearch(startVertex: Vertex<T>): ArrayList<Vertex<T>> {
    val queue = ArrayDeque<Vertex<T>>()
    val verticesTrace = arrayListOf<Vertex<T>>()
    val visited = arrayListOf<Vertex<T>>()

    queue.add(startVertex)
    verticesTrace.add(startVertex)

    while (queue.isNotEmpty()) {
        val currentVertex = queue.remove()

        visited.add(currentVertex)

        edges(currentVertex).forEach { edge ->
            if (!verticesTrace.contains(edge.to)) {
                queue.add(edge.to)
                verticesTrace.add(edge.to)
            }
        }
    }

    return visited
}

fun <T> Graph<T, out Edge<T>>.deepFirstSearch(startVertex: Vertex<T>): ArrayList<Vertex<T>> {
    val stack = ArrayDeque<Vertex<T>>()
    val visited = arrayListOf<Vertex<T>>()

    stack.push(startVertex)
    visited.add(startVertex)

    while (stack.isNotEmpty()) {
        val vertex = stack.peek()
        val edges = edges(vertex)

        if (edges.isEmpty()) {
            stack.pop()
            continue
        }

        val notVisitedNeighbor = edges.find { edge -> edge.to !in visited }?.to

        if (notVisitedNeighbor == null) {
            stack.pop()
        } else {
            stack.push(notVisitedNeighbor)
            visited.add(notVisitedNeighbor)
        }
    }

    return visited
}

fun <T> MutableGraph<T, out WeightedEdge<T>>.findShortestPath(from: Vertex<T>, to: Vertex<T>): GraphPath<T> {
    if (from == to) invalidArgumentError("From and To vertices are equals: ${from.data}")

    val queue = ArrayDeque<Vertex<T>>()
    val tracker = PathTracker<T>()

    // push first vertex in both queue and tracker
    tracker.initPath(from)
    queue.add(from)

    while (queue.isNotEmpty()) {
        // get vertex from queue
        val currentVertex = queue.remove()

        // check all edges. If the edge is good enough, refresh path and push this edge to queue
        edges(currentVertex).forEach { edge ->
            val targetVertex = edge.to
            // potential new weight with new edge
            val newPathWeight = tracker.calculatePathWeight(edge.from) + edge.weight

            if (!tracker.isTracked(targetVertex) || tracker.hasLowerWeight(targetVertex, newPathWeight)) {
                tracker.addOrUpdatePathEdge(edge, newPathWeight)
                queue.add(edge.to)
            }
        }
    }

    return tracker.collectPath(to)
}
