package algorithm.technique

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class BitManipulationKtTest : StringSpec({

    "sum with positive numbers" {
        sum(243, 13) shouldBe 256
    }

    "sum with negative number" {
        sum(43, -3) shouldBe 40
    }

})
