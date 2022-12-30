package problem.string

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LongestSubstringWithoutRepeatsKtTest : StringSpec({
    "test case 1" {
        val str = "abcabcbb"
        longestSubstringWithoutRepeats(str) shouldBe 3
    }

    "test case 2" {
        val str = "bbbbb"
        longestSubstringWithoutRepeats(str) shouldBe 1
    }

    "test case 3" {
        val str = "pwwkew"
        longestSubstringWithoutRepeats(str) shouldBe 3
    }

    "test case 4" {
        val str = " "
        longestSubstringWithoutRepeats(str) shouldBe 1
    }

    "test case 5" {
        val str = "dvdf"
        longestSubstringWithoutRepeats(str) shouldBe 3
    }
})
