package problem.array

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LongestIncreasingSubsequenceKtTest : StringSpec({

    "findLISLength returns correct length" {
        val input = intArrayOf(10, 22, 9, 33, 21, 50, 41, 60)
        longestIncreasingSubsequence(input) shouldBe 5

        val input2 = intArrayOf(1, 3, 1, 4, 5, 6, 7, 8)
        longestIncreasingSubsequence(input2) shouldBe 7

        val input3 = intArrayOf(3, 2, 6, 4, 5, 1)
        longestIncreasingSubsequence(input3) shouldBe 3

        val input4 = intArrayOf(9, 8, 7, 6, 5, 1)
        longestIncreasingSubsequence(input4) shouldBe 1

        val input5 = intArrayOf(9, 9, 9, 9, 9)
        longestIncreasingSubsequence(input5) shouldBe 1
    }

    "findLISLength handles empty input" {
        longestIncreasingSubsequence(intArrayOf()) shouldBe 0
    }

})
