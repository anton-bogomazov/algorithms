package problem.matrix

import exception.invalidArgumentError
import util.Matrix
import util.Point
import util.isInBounds

// Calculate the sum of all elements in a submatrix in constant time
// SumMatrix construction is O(n^2)/O(n^2)
fun findSubmatrixSum(matrix: Matrix<Int>, submatrixCoordinates: Pair<Point, Point>): Int {
    if (matrix.isEmpty()) return 0
    val (topLeftPoint, bottomRightPoint) = submatrixCoordinates
    if (!matrix.isInBounds(topLeftPoint) || !matrix.isInBounds(bottomRightPoint)) {
        invalidArgumentError("Coordinates must be in matrix bounds")
    }

    val sumMatrix = getSumMatrix(matrix)
    val fromStartToBottomRight = sumMatrix[bottomRightPoint.y][bottomRightPoint.x]
    val leftDiff = if (topLeftPoint.x == 0) 0 else sumMatrix[bottomRightPoint.y][topLeftPoint.x - 1]
    val topDiff = if (topLeftPoint.y == 0) 0 else sumMatrix[topLeftPoint.y - 1][bottomRightPoint.x]
    val topLeftCornerBetweenDiffs =
        if (leftDiff == 0 && topDiff == 0) 0 else sumMatrix[topLeftPoint.y - 1][topLeftPoint.x - 1]

    return fromStartToBottomRight - leftDiff - topDiff + topLeftCornerBetweenDiffs
}

private fun getSumMatrix(matrix: Matrix<Int>): Matrix<Int> {
    val sumMatrix = Matrix.intMatrix(matrix.rows.size, matrix.columns.size)

    sumMatrix[0][0] = matrix[0][0]
    for (j in 1..matrix.columns.lastIndex) {
        sumMatrix[0][j] = matrix[0][j] + sumMatrix[0][j - 1]
    }

    for (i in 1..matrix.rows.lastIndex) {
        sumMatrix[i][0] = matrix[i][0] + sumMatrix[i - 1][0]
    }

    for (i in 1..matrix.rows.lastIndex) {
        for (j in 1..matrix.columns.lastIndex) {
            sumMatrix[i][j] = matrix[i][j] + sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1]
        }
    }

    return sumMatrix
}
