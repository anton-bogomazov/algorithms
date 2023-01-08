package problem.string

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LongestPalindromicSubsequenceKtTest : StringSpec({
    "longest palindromic subsequence at beginning of sequence" {
        longestPalindromicSubsequence("racecar") shouldBe 7
    }

    "longest palindromic subsequence at end of sequence" {
        longestPalindromicSubsequence("a man a plan a canal panama") shouldBe 13
    }

    "longest palindromic subsequence is whole sequence" {
        longestPalindromicSubsequence("abcba") shouldBe 5
    }

    "sequence does not contain a palindromic subsequence" {
        longestPalindromicSubsequence("abcdef") shouldBe 1
    }
})
