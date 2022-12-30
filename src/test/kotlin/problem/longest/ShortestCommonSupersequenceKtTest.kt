package problem.longest

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ShortestCommonSupersequenceKtTest : StringSpec({
    "shortest common supersequence with no common characters" {
        val x = "abc"
        val y = "def"
        val expectedOutput = 6
        val actualOutput = shortestCommonSupersequence(x, y)
        actualOutput shouldBe expectedOutput
    }

    "shortest common supersequence with some common characters" {
        val x = "abcde"
        val y = "acf"
        val expectedOutput = 6
        val actualOutput = shortestCommonSupersequence(x, y)
        actualOutput shouldBe expectedOutput
    }

    "shortest common supersequence with very different strings" {
        val x = "abcdefghijklmnopqrstuvwxyz"
        val y = "zyxwvutsrqponmlkjihgfedcba"
        val expectedOutput = 51
        val actualOutput = shortestCommonSupersequence(x, y)
        actualOutput shouldBe expectedOutput
    }

    "shortest common supersequence with reversed strings" {
        val x = "abc"
        val y = "cba"
        val expectedOutput = 5
        val actualOutput = shortestCommonSupersequence(x, y)
        actualOutput shouldBe expectedOutput
    }

    "shortest common supersequence with empty strings" {
        val x = ""
        val y = ""
        val expectedOutput = 0
        val actualOutput = shortestCommonSupersequence(x, y)
        actualOutput shouldBe expectedOutput
    }
})
