package algorithm.sort

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe


class SortTest : StringSpec({

    val implementations = listOf(
        ::bubbleSort, ::insertionsSort, ::selectionSort, ::cycleSort,
        ::countingSort, ::heapSort, ::quickSort, ::mergeSort
    )

    "sort should sort an array of integers in ascending order" {
        implementations.forEach {
            val array = arrayOf(4, 2, 1, 1, 3)
            it(array)
            array shouldBe arrayOf(1, 1, 2, 3, 4)
        }
    }

})
