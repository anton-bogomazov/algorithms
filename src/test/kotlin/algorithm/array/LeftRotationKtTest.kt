package algorithm.array

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LeftRotationKtTest : StringSpec({
    "leftRotate should rotate the array to the left by the specified number of rotations" {
        val array = intArrayOf(1, 2, 3, 4, 5)
        val expected = intArrayOf(5, 1, 2, 3, 4)
        leftRotate(array, 4)
        array shouldBe expected
    }

    "leftRotate should handle numberOfRotations values greater than the length of the array" {
        val array = intArrayOf(1, 2, 3, 4, 5)
        val expected = intArrayOf(3, 4, 5, 1, 2)
        leftRotate(array, 7)
        array shouldBe expected
    }

    "leftRotate should handle empty arrays" {
        val array = intArrayOf()
        val expected = intArrayOf()
        leftRotate(array, 2)
        array shouldBe expected
    }
})
