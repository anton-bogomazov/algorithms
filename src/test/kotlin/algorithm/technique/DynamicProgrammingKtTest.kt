package algorithm.technique

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DynamicProgrammingKtTest : StringSpec({
    "fibonacci of 0 should be 0" {
        fibonacci(0) shouldBe 0
    }

    "fibonacci of 1 should be 1" {
        fibonacci(1) shouldBe 1
    }

    "fibonacci of 5 should be 5" {
        fibonacci(5) shouldBe 5
    }

    "fibonacci of 10 should be 55" {
        fibonacci(10) shouldBe 55
    }
})
