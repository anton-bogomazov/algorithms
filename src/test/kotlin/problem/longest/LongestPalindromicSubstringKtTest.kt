package problem.longest

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LongestPalindromicSubstringKtTest : StringSpec({
    "longest palindromic substring at beginning of string" {
        longestPalindromicSubstring("racecar") shouldBe 7
    }

    "longest palindromic substring at end of string" {
        longestPalindromicSubstring("a man plan a canal panaman") shouldBe 5
    }

    "longest palindromic substring is whole string" {
        longestPalindromicSubstring("abcba") shouldBe 5
    }

    "string does not contain a palindromic substring" {
        longestPalindromicSubstring("abcdef") shouldBe 1
    }
})
