package problem.solving

import exception.InvalidArgumentException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class CoinChangeProblemKtTest : FunSpec({
    val implementations = listOf(::countChange, ::countChangeWithHashmap, ::countChangeDP)

    context("Happy path") {
        withData(
            nameFn = { "${it.a.toList()}, ${it.b} -> ${it.c}" },
            row(intArrayOf(1, 3, 5, 7), 8, 6),
            row(intArrayOf(1, 1, 2, 3), 4, 4)
        ) { (array, target, expected) ->
            implementations.forEach { f ->
                f(array, target) shouldBe expected
            }
        }
    }

    context("Errors") {
        test("empty array") {
            implementations.forEach {
                shouldThrow<InvalidArgumentException> {
                    it(intArrayOf(), 8)
                }.message shouldBe "Array is empty"
            }
        }

        context("non positive denominators") {
            withData(
                nameFn = { "${it.a.toList()}" },
                row(intArrayOf(1, 0, 3), 8),
                row(intArrayOf(1, -2, 3), 8)
            ) { (array, target) ->
                implementations.forEach {
                    shouldThrow<InvalidArgumentException> {
                        it(array, target)
                    }.message shouldBe "Coin values must be positive"
                }
            }
        }
    }
})
