package problem.array

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LongestConsecutiveSubsequenceKtTest : StringSpec({
    "longest consecutive subsequence at beginning of array" {
        longestConsecutiveSubsequence(arrayOf(1, 9, 3, 10, 4, 20, 2)) shouldBe 4
    }

    "longest consecutive subsequence at end of array" {
        longestConsecutiveSubsequence(arrayOf(36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42)) shouldBe 5
    }

    "longest consecutive subsequence is whole array" {
        longestConsecutiveSubsequence(arrayOf(1, 2, 3, 4, 5, 6, 7, 8)) shouldBe 8
    }

    "array contains duplicate elements" {
        longestConsecutiveSubsequence(arrayOf(1, 2, 2, 3, 3, 3)) shouldBe 3
    }
})
