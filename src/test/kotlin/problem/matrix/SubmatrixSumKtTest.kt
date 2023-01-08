package problem.matrix

import exception.InvalidArgumentException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import util.Matrix
import util.Point

class SubmatrixSumKtTest : StringSpec({

    "findSubmatrixSum should return the correct result for a submatrix in the top left corner" {
        val matrix = Matrix.of(listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9)))
        val submatrixCoordinates = Pair(Point(0, 0), Point(1, 1))
        findSubmatrixSum(matrix, submatrixCoordinates) shouldBe 12
    }

    "findSubmatrixSum should return the correct result for a submatrix in the bottom right corner" {
        val matrix = Matrix.of(listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9)))
        val submatrixCoordinates = Pair(Point(1, 1), Point(2, 2))
        findSubmatrixSum(matrix, submatrixCoordinates) shouldBe 28
    }

    "findSubmatrixSum should return the correct result for a submatrix that spans the entire matrix" {
        val matrix = Matrix.of(listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9)))
        val submatrixCoordinates = Pair(Point(0, 0), Point(2, 2))
        findSubmatrixSum(matrix, submatrixCoordinates) shouldBe 45
    }

    "findSubmatrixSum should throw an exception for coordinates that are not in matrix bounds" {
        val matrix = Matrix.of(listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9)))
        val submatrixCoordinates = Pair(Point(-1, 0), Point(1, 1))
        shouldThrow<InvalidArgumentException> {
            findSubmatrixSum(matrix, submatrixCoordinates)
        }
    }

    "findSubmatrixSum returns correct sum for non-square matrix" {
        val matrix = Matrix.of(
            listOf(
                listOf(1, 2, 3, 4),
                listOf(5, 6, 7, 8),
                listOf(9, 10, 11, 12)
            )
        )
        val submatrixCoordinates = Pair(Point(1, 1), Point(3, 2))

        findSubmatrixSum(matrix, submatrixCoordinates) shouldBe 54
    }

    "findSubmatrixSum returns correct sum for submatrix of size 1x1" {
        val matrix = Matrix.of(
            listOf(
                listOf(1, 2, 3, 4),
                listOf(5, 6, 7, 8),
                listOf(9, 10, 11, 12)
            )
        )
        val submatrixCoordinates = Pair(Point(1, 1), Point(1, 1))

        findSubmatrixSum(matrix, submatrixCoordinates) shouldBe 6
    }

    "findSubmatrixSum returns correct sum for non-square matrix whole matrix" {
        val matrix = Matrix.of(
            listOf(
                listOf(1, 2, 3, 4),
                listOf(5, 6, 7, 8),
                listOf(9, 10, 11, 12)
            )
        )
        val submatrixCoordinates = Pair(Point(0, 0), Point(3, 2))

        findSubmatrixSum(matrix, submatrixCoordinates) shouldBe 78
    }
})
