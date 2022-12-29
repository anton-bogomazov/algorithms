package algorithm.find

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class FindPowerSetKtTest : StringSpec({
    "test finding subsets of an empty set" {
        val subsets = findPowerSet(arrayOf())
        subsets shouldBe setOf(setOf())
    }

    "test finding subsets of a set with one element" {
        val subsets = findPowerSet(arrayOf(1))
        subsets shouldBe setOf(setOf(), setOf(1))
    }

    "test finding subsets of a set with duplicated elements" {
        val subsets = findPowerSet(arrayOf(1, 1))
        subsets shouldBe setOf(setOf(), setOf(1))
    }

    "test finding subsets of a set with two elements" {
        val subsets = findPowerSet(arrayOf(1, 2))
        subsets shouldBe setOf(setOf(), setOf(1), setOf(2), setOf(1, 2))
    }

    "test finding subsets of a set with three elements" {
        val subsets = findPowerSet(arrayOf(1, 2, 3))
        subsets shouldBe setOf(
            setOf(),
            setOf(1),
            setOf(2),
            setOf(3),
            setOf(1, 2),
            setOf(1, 3),
            setOf(2, 3),
            setOf(1, 2, 3)
        )
    }
})
