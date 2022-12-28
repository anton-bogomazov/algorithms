package algorithm

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class FindMajorityElementKtTest : StringSpec({

    "test majority element at start of array" {
        val result = findMajorityElement(arrayOf(5, 5, 5, 2, 3))
        result shouldBe 5
    }

    "test majority element at end of array" {
        val result = findMajorityElement(arrayOf(1, 2, 5, 5, 5))
        result shouldBe 5
    }

    "test majority element in middle of array" {
        val result = findMajorityElement(arrayOf(5, 2, 5, 5, 3))
        result shouldBe 5
    }

    "test majority element mixed" {
        val result = findMajorityElement(arrayOf(5, 2, 5, 3, 5, 1, 5))
        result shouldBe 5
    }

    "test no majority element" {
        val result = findMajorityElement(arrayOf(1, 2, 3, 5, 5))
        result shouldBe null
    }

})
