package algorithm.merge

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class KWayMergeKtTest : StringSpec({
    "test k-way merge" {
        val arrays = arrayOf(
            arrayOf(1, 3, 5, 7),
            arrayOf(2, 4, 6, 8),
            arrayOf(0, 9, 10, 11)
        )
        val expected = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)

        kWayMerge(arrays) shouldBe expected
    }

    "test k-way merge with empty arrays" {
        val arrays = arrayOf(
            arrayOf<Int>(),
            arrayOf(),
            arrayOf()
        )
        val expected = emptyArray<Int>()

        kWayMerge(arrays) shouldBe expected
    }

    "test k-way merge with single element arrays" {
        val arrays = arrayOf(
            arrayOf(1),
            arrayOf(2),
            arrayOf(3)
        )
        val expected = arrayOf(1, 2, 3)

        kWayMerge(arrays) shouldBe expected
    }

    "test k-way merge with mixed arrays" {
        val arrays = arrayOf(
            arrayOf(1, 3, 5),
            arrayOf(2, 4),
            arrayOf()
        )
        val expected = arrayOf(1, 2, 3, 4, 5)

        kWayMerge(arrays) shouldBe expected
    }
})
