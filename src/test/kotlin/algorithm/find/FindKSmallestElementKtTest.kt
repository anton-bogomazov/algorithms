package algorithm.find

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class FindKSmallestElementKtTest : StringSpec({
    "test finding the kth smallest element in an array" {
        val arr = arrayOf(7, 4, 6, 3, 9, 1)
        val k = 2

        val result = quickSelect(arr, k)

        result shouldBe 3
    }

    "test finding the first smallest element in an array" {
        val arr = arrayOf(5, 4, 3, 2, 1)
        val k = 1

        val result = quickSelect(arr, k)

        result shouldBe 1
    }

    "test finding the last smallest element in an array" {
        val arr = arrayOf(5, 4, 3, 2, 1)
        val k = 5

        val result = quickSelect(arr, k)

        result shouldBe 5
    }
})
