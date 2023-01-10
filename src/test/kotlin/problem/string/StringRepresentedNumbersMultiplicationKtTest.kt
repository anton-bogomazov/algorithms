package problem.string

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringRepresentedNumbersMultiplicationKtTest : StringSpec({

    "multiply" {
        multiply("123456789", "987654321") shouldBe "121932631112635269"
    }

})
