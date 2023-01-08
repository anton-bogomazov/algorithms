package problem.array

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class MaxSumSubarrayKtTest : FunSpec({

    context("Happy path") {
        withData(
            nameFn = { "${it.a.toList()} -> ${it.b}" },
            row(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4), 6),
            row(intArrayOf(), 0),
            row(intArrayOf(-2, -3, -1, -5), -1),
            row(intArrayOf(2, 3, 1, 5), 11),
        ) { (array, expected) ->
            findMaxSumSubarray(array) shouldBe expected
        }
    }
})
