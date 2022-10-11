package problem.solving

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LongestCommonSubsequenceKtTest : FunSpec({
    val implementations = listOf(::findLcsRecursion, ::findLcsRecursionWithHashMap, ::findLcsDP)

    context("Happy path") {
        withData(
            nameFn = { "${it.a}, ${it.b} -> ${it.c}" },
            row("ABCBDAB", "BDCABA", 4),
            row("ABCDE", "FGKLO", 0),
            row("", "", 0)
        ) { (firstSeq, secondSeq, expected) ->
            implementations.forEach { f ->
                f(firstSeq, secondSeq) shouldBe expected
            }
        }
    }
})
