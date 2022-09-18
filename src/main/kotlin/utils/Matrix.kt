package utils

class Matrix<T> private constructor(height: Int, width: Int, initWith: T) {

    companion object {
        fun <T> matrix(height: Int, width: Int, initWith: T) = Matrix(height, width, initWith).matrix

        fun intMatrix(height: Int, width: Int) = Matrix(height, width, 0).matrix
    }

    private val matrix: MutableList<MutableList<T>> =
        (1..height).map { (1..width).map { initWith }.toMutableList() }.toMutableList()

}