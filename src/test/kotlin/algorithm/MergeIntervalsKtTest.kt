package algorithm

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MergeIntervalsKtTest : StringSpec({
    "mergeIntervals - multiple intervals" {
        mergeIntervals(arrayOf(Interval(1, 3), Interval(2, 4), Interval(6, 8), Interval(9, 10))) shouldBe
                arrayOf(Interval(1, 4), Interval(6, 8), Interval(9, 10))
    }

    "mergeIntervals - merge into one" {
        mergeIntervals(arrayOf(Interval(6, 8), Interval(1, 9), Interval(2, 4), Interval(4, 7))) shouldBe
                arrayOf(Interval(1, 9))
    }
})
