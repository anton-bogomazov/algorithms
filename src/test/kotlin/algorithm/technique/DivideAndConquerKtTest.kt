package algorithm.technique

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DivideAndConquerKtTest : StringSpec({
    "should find the target element in the array" {
        val arr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val target = 5

        binarySearch(arr, target) shouldBe 4
    }

    "should return -1 if the target element is not in the array" {
        val arr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val target = 10

        binarySearch(arr, target) shouldBe -1
    }
})
