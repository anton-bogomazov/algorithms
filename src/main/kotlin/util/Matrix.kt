package util

import exception.invalidArgumentError

class Matrix<T> private constructor(rows: List<List<T>>) {

    companion object {
        fun <T> init(height: Int, width: Int, initWith: T) = Matrix(primitiveMatrix(height, width, initWith))

        fun intMatrix(height: Int, width: Int) = Matrix(primitiveMatrix(height, width, 0))

        fun <T> of(rows: List<List<T>>) = Matrix(rows)

        private fun <T> primitiveMatrix(height: Int, width: Int, initWith: T) =
            (1..height).map { (1..width).map { initWith }.toMutableList() }
    }

    // fixme list is mutable -> it's possible to add new elements and make list inconsistent
    private val matrix: List<MutableList<T>> = rows.map { it.toMutableList() }

    val rows: List<MutableList<T>>
    val columns: List<MutableList<T>>

    val height: Int = matrix.size
    val width: Int = matrix.first().size

    init {
        if (height < 1 || width < 1) invalidArgumentError("Height and width should be positive")
        this.rows = matrix
        this.columns = rotateMatrix90DegreesClockwise()
    }

    operator fun get(row: Int) = matrix[row]

    private fun rotateMatrix90DegreesClockwise(): MutableList<MutableList<T>> {
        val transposedMatrix = primitiveMatrix(width, height, matrix[0][0])

        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                transposedMatrix[j][i] = matrix[i][j]
            }
        }

        return transposedMatrix.map { it.reversed().toMutableList() }.toMutableList()
    }

    fun isEmpty() = matrix.isEmpty()

    override fun toString(): String = Table(matrix.map { it.map { it.toString() } }).toString()
}
