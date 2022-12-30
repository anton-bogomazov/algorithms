package problem.string

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LongestRepeatingCharacterReplacementKtTest : StringSpec({
    "test case 1" {
        val str = "ABAB"
        val k = 2
        longestRepeatingCharacterReplacement(str, k) shouldBe 4
    }

    "test case 2" {
        val str = "AABABBA"
        val k = 1
        longestRepeatingCharacterReplacement(str, k) shouldBe 4
    }

    "test case 3" {
        val str = "ABBBBBBBBB"
        val k = 2
        longestRepeatingCharacterReplacement(str, k) shouldBe 10
    }

    "test case 4" {
        val str = "BAAAAB"
        val k = 2
        longestRepeatingCharacterReplacement(str, k) shouldBe 6
    }

    "test case 5" {
        val str = "BBBBBBBBBBB"
        val k = 0
        longestRepeatingCharacterReplacement(str, k) shouldBe 11
    }
})
