package problem.string

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MakingAnagramsKtTest : StringSpec({
    "test case 1" {
        val a = "cde"
        val b = "abc"
        makingAnagrams(a, b) shouldBe 4
    }

    "test case 4" {
        val a = "abcdefghijklmnopqrstuvwxyz"
        val b = "zyxwvutsrqponmlkjihgfedcba"
        makingAnagrams(a, b) shouldBe 0
    }
})
