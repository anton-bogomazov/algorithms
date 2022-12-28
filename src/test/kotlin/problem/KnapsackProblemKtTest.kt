package problem

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class KnapsackProblemKtTest : FunSpec({
    val implementations = listOf(::collectKnapsack, ::collectKnapsackWithHashmap, ::collectKnapsackDP)

    context("Happy path") {
        withData(
            nameFn = { "items:${it.a.toList()}, capacity:${it.b} -> ${it.c}" },
            row(listOf(20 to 1, 5 to 2, 10 to 3, 40 to 8, 15 to 7, 25 to 4), 10, 60),
            row(listOf(20 to 1, 5 to 1, 10 to 2), 2, 25),
            row(listOf(1 to 1, 1 to 1, 3 to 2), 2, 3)
        ) { (items, capacity, expected) ->
            implementations.forEach { f ->
                f(items, capacity) shouldBe expected
            }
        }
    }

})
