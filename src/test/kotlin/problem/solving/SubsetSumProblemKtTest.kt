package problem.solving

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class SubsetSumProblemKtTest : FunSpec({
    val implementations = listOf(::findSubset, ::findSubsetWithHashmap, ::findSubsetDP)

    context("Happy path") {
        withData(
            nameFn = { "${it.a.toList()}, ${it.b} -> ${it.c}" },
            row(intArrayOf(7, 3, 2, 5, 8), 14, true),
            row(intArrayOf(7, 14, 2, 5), 14, true),
            row(intArrayOf(7, 3, 2), 4, false)
        ) { (array, target, expected) ->
            implementations.forEach { f ->
                f(array, target) shouldBe expected
            }
        }
    }
})
