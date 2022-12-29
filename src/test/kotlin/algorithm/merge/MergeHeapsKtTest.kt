package algorithm.merge

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.shouldBe

class MergeHeapsKtTest : StringSpec({
    "test merging two heaps" {
        val arr1 = arrayOf(10, 5, 6, 2)
        val arr2 = arrayOf(12, 7, 9)
        val merged = mergeHeaps(arr1, arr2)
        merged shouldBe arrayOf(12, 10, 9, 2, 5, 7, 6)
    }

    "test merging two empty heaps" {
        val arr1 = emptyArray<Int>()
        val arr2 = emptyArray<Int>()
        val merged = mergeHeaps(arr1, arr2)

        merged.shouldBeEmpty()
    }

    "test merging one empty heap and one non-empty heap" {
        val arr1 = arrayOf(10, 5, 6, 2)
        val arr2 = emptyArray<Int>()
        val merged = mergeHeaps(arr1, arr2)

        merged shouldBe arrayOf(10, 5, 6, 2)
    }
})
