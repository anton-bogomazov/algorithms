package problem.longest

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LongestConsecutiveSubarrayKtTest : StringSpec({
    "longest consecutive subarray at beginning of array" {
        longestConsecutiveSubarray(arrayOf(1, 3, 2, 0, 10, 4, 20, 2)) shouldBe 4
    }

    "longest consecutive subarray at end of array" {
        longestConsecutiveSubarray(arrayOf(36, 41, 56, 35, 44, 33, 34, 92, 43, 44, 42)) shouldBe 3
    }

    "longest consecutive subarray is whole array" {
        longestConsecutiveSubarray(arrayOf(1, 2, 3, 4, 5, 6, 7, 8)) shouldBe 8
    }

    "array contains duplicate elements" {
        longestConsecutiveSubarray(arrayOf(1, 2, 2, 3, 3, 3)) shouldBe 2
    }
})
