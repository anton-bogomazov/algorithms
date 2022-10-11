package util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import util.Matrix.Companion.intMatrix
import util.Matrix.Companion.matrix

class MatrixTest {

    @Test
    fun `create generic matrix`() {
        val width = 5
        val height = 10
        val value = "String"

        val matrix = matrix(height, width, value)

        matrix.forEach { row ->
            assertThat(row.size).isEqualTo(width)
            row.forEach { cell ->
                assertThat(cell).isEqualTo(value)
            }
        }
        assertThat(matrix.size).isEqualTo(height)
    }

    @Test
    fun `create int matrix`() {
        val width = 5
        val height = 10
        val value = 0

        val matrix = intMatrix(height, width)

        matrix.forEach { row ->
            assertThat(row.size).isEqualTo(width)
            row.forEach { cell ->
                assertThat(cell).isEqualTo(value)
            }
        }
        assertThat(matrix.size).isEqualTo(height)
    }

    @Test
    fun `create generic matrix - negative sizes - create empty`() {
        val width = -1
        val height = -1
        val value = "String"

        val matrix = matrix(height, width, value)

        matrix.forEach { row ->
            assertThat(row.size).isEqualTo(0)
            row.forEach { cell ->
                assertThat(cell).isEqualTo(value)
            }
        }
        assertThat(matrix.size).isEqualTo(0)
    }

    @Test
    fun `create generic matrix - nil sizes - create empty`() {
        val width = 0
        val height = 0
        val value = "String"

        val matrix = matrix(height, width, value)

        matrix.forEach { row ->
            assertThat(row.size).isEqualTo(width)
            row.forEach { cell ->
                assertThat(cell).isEqualTo(value)
            }
        }
        assertThat(matrix.size).isEqualTo(height)
    }

}
