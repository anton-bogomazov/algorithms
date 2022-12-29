package algorithm.array

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class FindShortestPathInMazeKtTest : StringSpec({
    "lee should return the correct shortest path" {
        val maze = arrayOf(
            arrayOf(1, 1, 1, 1, 1, 1),
            arrayOf(0, 1, 0, 1, 0, 1),
            arrayOf(0, 1, 0, 0, 0, 0),
            arrayOf(0, 1, 1, 1, 1, 1),
            arrayOf(0, 1, 1, 1, 1, 1)
        )
        val start = Pair(0, 0)
        val end = Pair(4, 5)

        val result = findShortestPath(maze, start, end)

        result shouldBe 9
    }

    "lee no solution" {
        val maze = arrayOf(
            arrayOf(1, 1, 1, 1, 1, 1),
            arrayOf(0, 1, 0, 1, 0, 1),
            arrayOf(0, 1, 0, 0, 0, 0),
            arrayOf(0, 1, 1, 1, 0, 1),
            arrayOf(0, 1, 1, 1, 0, 1)
        )
        val start = Pair(0, 0)
        val end = Pair(4, 5)

        val result = findShortestPath(maze, start, end)

        result shouldBe -1
    }

})
