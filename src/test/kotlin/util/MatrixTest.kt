package util

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MatrixTest : StringSpec({

    "init should create a matrix of the specified dimensions and initialized with the given value" {
        val matrix = Matrix.init(2, 3, "yo")
        matrix.height shouldBe 2
        matrix.width shouldBe 3
        matrix[0][0] shouldBe "yo"
        matrix[0][1] shouldBe "yo"
        matrix[0][2] shouldBe "yo"
        matrix[1][0] shouldBe "yo"
        matrix[1][1] shouldBe "yo"
        matrix[1][2] shouldBe "yo"
    }

    "intMatrix should create a matrix of the specified dimensions initialized with zeros" {
        val matrix = Matrix.intMatrix(3, 2)
        matrix.height shouldBe 3
        matrix.width shouldBe 2
        matrix[0][0] shouldBe 0
        matrix[0][1] shouldBe 0
        matrix[1][0] shouldBe 0
        matrix[1][1] shouldBe 0
        matrix[2][0] shouldBe 0
        matrix[2][1] shouldBe 0
    }

    "of should create a matrix from the given rows" {
        val matrix = Matrix.of(listOf(listOf(1, 2, 3), listOf(4, 5, 6)))
        matrix.height shouldBe 2
        matrix.width shouldBe 3
        matrix[0][0] shouldBe 1
        matrix[0][1] shouldBe 2
        matrix[0][2] shouldBe 3
        matrix[1][0] shouldBe 4
        matrix[1][1] shouldBe 5
        matrix[1][2] shouldBe 6
    }

    "isInBounds - true" {
        val matrix = Matrix.of(listOf(listOf(1, 2, 3), listOf(4, 5, 6)))

        matrix.isInBounds(0 with 0) shouldBe true
        matrix.isInBounds(0 with 1) shouldBe true
        matrix.isInBounds(1 with 0) shouldBe true
        matrix.isInBounds(2 with 1) shouldBe true
    }

    "isInBounds - false" {
        val matrix = Matrix.of(listOf(listOf(1, 2, 3), listOf(4, 5, 6)))

        matrix.isInBounds(-1 with 0) shouldBe false
        matrix.isInBounds(3 with 0) shouldBe false
        matrix.isInBounds(0 with 4) shouldBe false
        matrix.isInBounds(5 with 7) shouldBe false
    }

})
