package algorithm

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class FindGreatestCommonDivisorKtTest : StringSpec({

    "test gcd of 15 and 10" {
        val result = findGreatestCommonDivisor(15, 10)
        result shouldBe 5
    }

    "test gcd of 21 and 14" {
        val result = findGreatestCommonDivisor(21, -14)
        result shouldBe 7
    }

    "test gcd of 1 and 1" {
        val result = findGreatestCommonDivisor(1, 1)
        result shouldBe 1
    }

    "test gcd of 0 and 1" {
        val result = findGreatestCommonDivisor(0, 1)
        result shouldBe 1
    }

})
