package algorithm.array

// Lee Algorithm
// Given a maze in the form of the binary rectangular matrix,
// find the shortest path’s length in a maze from a given source to a given destination.
// Complexity time/space: O(m*n)/O(m*n)
fun findShortestPath(maze: Array<Array<Int>>, start: Pair<Int, Int>, end: Pair<Int, Int>): Int {
    val (i, j) = start
    val (x, y) = end
    if (maze.isEmpty() || maze[i][j] == 0 || maze[x][y] == 0) return -1

    val m = maze.size
    val n = maze[0].size

    // construct a matrix to keep track of visited cells
    val visited = Array(m) { BooleanArray(n) }

    // create an empty queue
    val q: ArrayDeque<Point> = ArrayDeque()

    // mark the source cell as visited and enqueue the source node
    visited[i][j] = true
    q.add(Point(i, j, 0))

    // stores length of the longest path from source to destination
    var minDistance = Int.MAX_VALUE

    // loop till queue is empty
    while (!q.isEmpty()) {
        // dequeue front node and process it
        // (i, j) represents a current cell, and `dist` stores its minimum distance from the source
        val (i, j, dist) = q.removeFirst()

        // if the destination is found, update `minDistance` and stop
        if (i == x && j == y) {
            minDistance = dist
            break
        }

        // check for all four possible movements from the current cell
        // and enqueue each valid movement
        for (k in 0..3) {
            // check if it is possible to go to position
            // (i + row[k], j + col[k]) from current position
            if (isValid(maze, visited, i + row[k], j + col[k])) {
                // mark next cell as visited and enqueue it
                visited[i + row[k]][j + col[k]] = true
                q.add(Point(i + row[k], j + col[k], dist + 1))
            }
        }
    }

    // No solution
    if (minDistance == Int.MAX_VALUE) return -1

    return minDistance
}

// Below arrays detail all four possible movements from a cell
private val row = intArrayOf(-1, 0, 0, 1)
private val col = intArrayOf(0, -1, 1, 0)

// Function to check if it is possible to go to position (row, col)
// from the current position. The function returns false if (row, col)
// is not a valid position or has a value 0 or already visited.
private fun isValid(mat: Array<Array<Int>>, visited: Array<BooleanArray>, row: Int, col: Int): Boolean {
    return row >= 0 && row < mat.size && col >= 0 && col < mat[0].size && mat[row][col] == 1 && !visited[row][col]
}

data class Point(val x: Int, val y: Int, val minDistance: Int)
