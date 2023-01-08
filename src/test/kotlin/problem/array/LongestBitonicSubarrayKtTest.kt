package problem.array

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LongestBitonicSubarrayKtTest : StringSpec({

    "longestBitonicSubarray should return the correct result for a bitonic array" {
        val array = intArrayOf(1, 2, 3, 4, 3, 2, 1)
        longestBitonicSubarray(array) shouldBe 7
    }

    "longestBitonicSubarray should return the correct result for an increasing array" {
        val array = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        longestBitonicSubarray(array) shouldBe 7
    }

    "longestBitonicSubarray should return the correct result for a decreasing array" {
        val array = intArrayOf(7, 6, 5, 4, 3, 2, 1)
        longestBitonicSubarray(array) shouldBe 7
    }

    "longestBitonicSubarray should return the correct result for an array with all equal elements" {
        val array = intArrayOf(5, 5, 5, 5, 5, 5, 5)
        longestBitonicSubarray(array) shouldBe 1
    }

    "longestBitonicSubarray should return the correct result for an empty array" {
        val array = intArrayOf()
        longestBitonicSubarray(array) shouldBe 0
    }

})
