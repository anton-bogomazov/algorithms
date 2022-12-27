package algorithm.array

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class FloodFillKtTest : StringSpec({

    "should fill a single pixel image" {
        val image = arrayOf(arrayOf(1))
        val expected = arrayOf(arrayOf(2))

        floodFill(image, 0, 0, 2) shouldBe expected
    }

    "should fill a 3x3 image" {
        val image = arrayOf(
            arrayOf(1, 1, 1),
            arrayOf(1, 1, 1),
            arrayOf(1, 1, 1)
        )
        val expected = arrayOf(
            arrayOf(2, 2, 2),
            arrayOf(2, 2, 2),
            arrayOf(2, 2, 2)
        )

        floodFill(image, 1, 1, 2) shouldBe expected
    }

    "should fill only exact color area" {
        val image = arrayOf(
            arrayOf(1, 1, 1),
            arrayOf(1, 2, 2),
            arrayOf(1, 2, 1)
        )
        val expected = arrayOf(
            arrayOf(1, 1, 1),
            arrayOf(1, 1, 1),
            arrayOf(1, 1, 1)
        )

        floodFill(image, 1, 1, 1) shouldBe expected
    }

    "should not fill if new color is the same as the old color" {
        val image = arrayOf(
            arrayOf(1, 1, 1),
            arrayOf(1, 1, 1),
            arrayOf(1, 1, 1)
        )
        val expected = arrayOf(
            arrayOf(1, 1, 1),
            arrayOf(1, 1, 1),
            arrayOf(1, 1, 1)
        )

        floodFill(image, 1, 1, 1) shouldBe expected
    }
})
