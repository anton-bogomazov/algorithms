package problem.array

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ArrayPermutationsKtTest : StringSpec({

    "permute in array" {
        val array = arrayOf(1, 2, 3)

        permute(array, 0, array.lastIndex)

        set shouldBe setOf(
            arrayOf(1, 2, 3),
            arrayOf(2, 1, 3),
            arrayOf(1, 3, 2),
            arrayOf(2, 3, 1),
            arrayOf(3, 1, 2),
            arrayOf(3, 2, 1)
        )
    }

})
