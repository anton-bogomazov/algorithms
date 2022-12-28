package problem

import exception.NoSolutionException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class TwoSumProblemKtTest : FunSpec({
    val implementations = listOf(::findPairBruteforce, ::findPairTwoPointers, ::findPairWithSet)

    context("Happy path") {
        withData(
            nameFn = { "${it.a.toList()}, ${it.b} -> ${it.c}" },
            row(intArrayOf(8, 7, 2, 5, 3, 1, 10, 151), 154, 3 to 151),
            row(intArrayOf(0, 0, 1, 2, 1), 2, 0 to 2)
        ) { (array, target, expected) ->
            implementations.forEach { f ->
                f(array, target) shouldBe expected
            }
        }
    }

    context("Error") {
        withData(
            nameFn = { "${it.a.toList()}, ${it.b}" },
            row(intArrayOf(8, 7, 2, 5, 3, 1, 10), 154),
            row(intArrayOf(), 3),
            row(intArrayOf(0, 1, 1, 1, 0), 3)
        ) { (array, target) ->
            implementations.forEach { f ->
                shouldThrow<NoSolutionException> {
                    f(array, target)
                }.message shouldBe "There is no solution"
            }
        }
    }
})
