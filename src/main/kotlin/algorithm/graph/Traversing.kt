package algorithm.graph

import data.structure.container.graph.Edge
import data.structure.container.graph.Graph
import data.structure.container.graph.Vertex
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
