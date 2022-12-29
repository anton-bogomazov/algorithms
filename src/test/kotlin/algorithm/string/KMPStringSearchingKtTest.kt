package algorithm.string

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class KMPStringSearchingKtTest : StringSpec({
    "test search with exact match" {
        val result = kmpSearch("hello", "hello")
        result shouldBe listOf(0)
    }

    "test search with a few matches" {
        val result = kmpSearch("ABCABAABCABAC", "CAB")
        result shouldBe listOf(2, 8)
    }

    "test search with partial match" {
        val result = kmpSearch("hello", "el")
        result shouldBe listOf(1)
    }

    "test search with no match" {
        val result = kmpSearch("hello", "world")
        result shouldBe listOf()
    }

    "test search with empty pattern" {
        val result = kmpSearch("hello", "")
        result shouldBe listOf(0)
    }

    "test search with empty text" {
        val result = kmpSearch("", "hello")
        result shouldBe listOf()
    }
})
