package problem.string

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LongestRepeatedSubsequenceKtTest : StringSpec({
    "longestRepeatedSubsequence should return the correct result for a string with no repeated subsequences" {
        val string = "abcdefghijklmnopqrstuvwxyz"
        longestRepeatedSubsequence(string) shouldBe 0
    }

    "longestRepeatedSubsequence should return the correct result for a string with a repeated subsequence at the beginning" {
        val string = "abcabcdefghijklmnopqrstuvwxyz"
        longestRepeatedSubsequence(string) shouldBe 3
    }

    "longestRepeatedSubsequence should return the correct result for a string with a repeated subsequence at the end" {
        val string = "abcdefghijklmnopqrstuvwxyzabc"
        longestRepeatedSubsequence(string) shouldBe 3
    }

    "longestRepeatedSubsequence should return the correct result for a string with a repeated subsequence in the middle" {
        val string = "abcdefgabcdefghijklmnopqrstuvwxyz"
        longestRepeatedSubsequence(string) shouldBe 7
    }

    "longestRepeatedSubsequence should return the correct result for a string with all equal elements" {
        val string = "aaaaaaaaaaaaaaaaaaaaaa"
        longestRepeatedSubsequence(string) shouldBe 21
    }

    "longestRepeatedSubsequence should return the correct result" {
        val string = "ATACTCGGA"
        longestRepeatedSubsequence(string) shouldBe 4
    }

})
