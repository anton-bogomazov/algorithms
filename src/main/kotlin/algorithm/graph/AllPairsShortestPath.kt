package algorithm.graph

import data.structure.container.graph.Vertex
import data.structure.container.graph.WeightedGraph

// Floyd Warshall Algorithm
// Find the shortest path weights from every source for all vertices in the graph.
// Worst case complexity time/space: O(n^3)/O(n^2)
fun <T> findAllPairsShortestPath(graph: WeightedGraph<T>): Map<Pair<Vertex<T>, Vertex<T>>, List<Vertex<T>>> {
    val vertices = graph.vertices()

    // cost[] and path[] stores (shortest cost/shortest route) information
    val cost = Array(vertices.size) { Array(vertices.size) { 0 } }
    val path = Array(vertices.size) { Array(vertices.size) { 0 } }

    // initialize cost[] and path[]
    for (i in vertices.indices) {
        val vertex = graph.vertices()[i]
        for (j in vertices.indices) {
            val otherVertex = graph.vertices()[j]
            if (vertex == otherVertex) {
                cost[i][j] = 0
                path[i][j] = i
            } else {
                cost[i][j] = Int.MAX_VALUE
                path[i][j] = -1
            }
        }
    }

    // Update the distance between each pair of vertices to the weight of the corresponding edge, if one exists
    for (edge in graph.edges()) {
        val fromIndex = graph.vertices().indexOf(edge.from)
        val toIndex = graph.vertices().indexOf(edge.to)
        cost[fromIndex][toIndex] = edge.weight.toInt()
        path[fromIndex][toIndex] = fromIndex
    }

    // run Floyd–Warshall
    for (k in vertices.indices) {
        for (i in vertices.indices) {
            for (j in vertices.indices) {
                // If vertex `k` is on the shortest path from `i` to `j`,
                // then update the value of cost[i][j] and path[i][j]
                if (cost[i][k] != Int.MAX_VALUE
                    && cost[k][j] != Int.MAX_VALUE
                    && (cost[i][k] + cost[k][j] < cost[i][j])
                ) {
                    cost[i][j] = cost[i][k] + cost[k][j]
                    path[i][j] = path[k][j]
                }
            }
            // If diagonal element becomes negative, the graph contains a negative-weight cycle
            if (cost[i][i] < 0) {
                throw IllegalArgumentException("Negative-weight cycle found!!")
            }
        }
    }

    // Collect the result into a map
    val result = mutableMapOf<Pair<Vertex<T>, Vertex<T>>, List<Vertex<T>>>()
    for (i in vertices.indices) {
        val vertex = graph.vertices()[i]
        for (j in vertices.indices) {
            val otherVertex = graph.vertices()[j]
            if (vertex != otherVertex && path[i][j] != -1) {
                val route = mutableListOf<Vertex<T>>()
                route.add(vertex)
                getPath(path, i, j, vertices, route)
                route.add(otherVertex)
                result[Pair(vertex, otherVertex)] = route
            }
        }
    }

    return result
}

// Recursive function to get the path of a given vertex `u` from source vertex `v`
private fun <T> getPath(
    path: Array<Array<Int>>,
    v: Int,
    u: Int,
    vertices: List<Vertex<T>>,
    route: MutableList<Vertex<T>>
) {
    if (path[v][u] == v) return

    getPath(path, v, path[v][u], vertices, route)
    route.add(vertices[path[v][u]])
}
