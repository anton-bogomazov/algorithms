package problem.longest

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.beEmpty

class LongestCommonPrefixKtTest : StringSpec({
    "test longest common prefix - empty set" {
        longestCommonPrefix(emptySet()) should beEmpty()
    }

    "test longest common prefix - single element set" {
        longestCommonPrefix(setOf("abc")) shouldBe "abc"
    }

    "test longest common prefix - multiple element set with common prefix" {
        longestCommonPrefix(setOf("abcdef", "abcghi", "abcjkl")) shouldBe "abc"
    }

    "test longest common prefix - multiple element set with no common prefix" {
        longestCommonPrefix(setOf("abcdef", "ghijkl", "mnoqrs")) should beEmpty()
    }

    "test longest common prefix - multiple element set with partial common prefix" {
        longestCommonPrefix(setOf("abcdef", "abcghi", "abjkl")) shouldBe "ab"
    }

    "test longest common prefix - multiple element set with short word" {
        longestCommonPrefix(setOf("ab", "abckef", "abckefj")) shouldBe "ab"
    }

    "test longest common prefix - multiple element set with empty string" {
        longestCommonPrefix(setOf("", "abckef", "abckefj")) shouldBe ""
    }
})
