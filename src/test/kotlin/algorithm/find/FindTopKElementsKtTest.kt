package algorithm.find

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class FindTopKElementsKtTest : StringSpec({
    "testFindKFrequentNumbers" {
        findKFrequentNumbers(arrayOf(1, 3, 2, 1, 2, 2, 3), 2) shouldBe listOf(2, 3)
    }

    "testFindKFrequentNumbersKGreaterThanUniqueElements" {
        findKFrequentNumbers(arrayOf(1, 3, 2, 1, 2, 2, 3), 10) shouldBe listOf(2, 3, 1)
    }

    "testFindKFrequentNumbersEmptyArray" {
        findKFrequentNumbers(emptyArray(), 1) shouldBe emptyList()
    }
})
