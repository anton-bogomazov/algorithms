package data.type

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlin.math.round

// todo write expected pointed numbers in some other form
class ComplexNumberTest : StringSpec({
    "from real and imaginary parts" {
        val number = ComplexNumber.from("3+4i")
        number.real shouldBe 3.0
        number.imaginary shouldBe 4.0
    }

    "from real and imaginary parts with point" {
        val number = ComplexNumber.from("3.4+4i")
        number.real shouldBe 3.4
        number.imaginary shouldBe 4.0
    }

    "from negative real and imaginary parts" {
        val number = ComplexNumber.from("-3+4i")
        number.real shouldBe -3.0
        number.imaginary shouldBe 4.0
    }

    "from real and negative imaginary parts" {
        val number = ComplexNumber.from("3+-4i")
        number.real shouldBe 3.0
        number.imaginary shouldBe -4.0
    }

    "from only real part".config(enabled = false) {
        val number = ComplexNumber.from("3")
        number.real shouldBe 3.0
        number.imaginary shouldBe 0.0
    }

    "from only negative real part".config(enabled = false) {
        val number = ComplexNumber.from("-3")
        number.real shouldBe -3.0
        number.imaginary shouldBe 0.0
    }

    "from only imaginary part".config(enabled = false) {
        val number = ComplexNumber.from("4i")
        number.real shouldBe 0.0
        number.imaginary shouldBe 4.0
    }

    "from only negative imaginary part".config(enabled = false) {
        val number = ComplexNumber.from("-4i")
        number.real shouldBe 0.0
        number.imaginary shouldBe 4.0
    }

    "abs() method" {
        val number = ComplexNumber(3.0, 4.0)
        number.abs() shouldBe 5.0
    }

    "phase() method" {
        val number = ComplexNumber(3.0, 5.0)
        number.phase() shouldBe 1.0303768265243125
    }

    "scale() method" {
        val number = ComplexNumber(3.0, 4.0)
        val newNumber = number.scale(2.0)
        newNumber.real shouldBe 6.0
        newNumber.imaginary shouldBe 8.0
    }

    "+ operator" {
        val number1 = ComplexNumber(3.0, 4.0)
        val number2 = ComplexNumber(2.0, -5.0)
        val sum = number1 + number2
        sum.real shouldBe 5.0
        sum.imaginary shouldBe -1.0
    }

    "- operator" {
        val number1 = ComplexNumber(3.0, 4.0)
        val number2 = ComplexNumber(2.0, -5.0)
        val difference = number1 - number2
        difference.real shouldBe 1.0
        difference.imaginary shouldBe 9.0
    }

    "* operator" {
        val number1 = ComplexNumber(1.0, -1.0)
        val number2 = ComplexNumber(1.0, -1.0)
        val product = number1 * number2
        product.real shouldBe 0.0
        product.imaginary shouldBe -2.0
    }

    "/ operator" {
        val number1 = ComplexNumber(1.0, -3.0)
        val number2 = ComplexNumber(1.0, 2.0)
        val quotient = number1 / number2
        round(quotient.real) shouldBe -1.0
        round(quotient.imaginary) shouldBe -1.0
    }

    "conjugate() method" {
        val number1 = ComplexNumber(3.0, 4.0)
        val conjugate = number1.conjugate()
        conjugate.real shouldBe 3.0
        conjugate.imaginary shouldBe -4.0
    }

    "exp() method" {
        val number1 = ComplexNumber(1.0, 2.0)
        val exp = number1.exp()

        exp.real shouldBe -1.1312043837568138
        exp.imaginary shouldBe 2.471726672004819
    }

    "sin() method" {
        val number1 = ComplexNumber(1.0, 2.0)
        val sin = number1.sin()

        sin.real shouldBe 3.165778513216168
        sin.imaginary shouldBe 1.9596010414216063
    }

    "cos() method" {
        val number1 = ComplexNumber(1.0, 2.0)
        val cos = number1.cos()

        cos.real shouldBe 2.0327230070196656
        cos.imaginary shouldBe -3.0518977991518
    }

    "tan() method" {
        val number1 = ComplexNumber(1.0, 2.0)
        val tan = number1.tan()

        tan.real shouldBe 0.03381282607989666
        tan.imaginary shouldBe 1.0147936161466338
    }

    "toString() real and imaginary parts" {
        ComplexNumber(3.0, 4.0).toString() shouldBe "3.0+4.0i"
    }

    "toString() only imaginary parts" {
        ComplexNumber(0.0, 4.0).toString() shouldBe "4.0i"
    }

    "toString() only real parts" {
        ComplexNumber(3.0, 0.0).toString() shouldBe "3.0"
    }

})
