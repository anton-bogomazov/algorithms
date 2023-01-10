package data.type

import kotlin.math.*

// todo document it. it's hard to understand wtf it's doing, e.g. phase method
data class ComplexNumber(
    val real: Double,
    val imaginary: Double
) {

    companion object {
        // todo parse also strings like "3", "-7i", conjugates like "3-7i"
        fun from(number: String): ComplexNumber {
            val (real, imaginary) = number.dropLast(1).split("+").map { it.toDouble() }
            return ComplexNumber(real, imaginary)
        }
    }

    fun abs() = hypot(real, imaginary)

    fun phase() = atan2(imaginary, real)

    fun scale(alpha: Double) = ComplexNumber(alpha * real, alpha * imaginary)

    fun conjugate() = ComplexNumber(real, -imaginary)

    fun exp() = ComplexNumber(exp(real) * cos(imaginary), exp(real) * sin(imaginary))

    fun sin() = ComplexNumber(sin(real) * cosh(imaginary), cos(real) * sinh(imaginary))

    fun cos() = ComplexNumber(cos(real) * cosh(imaginary), -sin(real) * sinh(imaginary))

    fun tan() = sin() / cos()

    fun reciprocal(): ComplexNumber {
        val scale = real.pow(2) + imaginary.pow(2)
        return ComplexNumber(real / scale, -imaginary / scale)
    }

    operator fun plus(other: ComplexNumber) =
        ComplexNumber(this.real + other.real, this.imaginary + other.imaginary)

    operator fun minus(other: ComplexNumber) =
        ComplexNumber(this.real - other.real, this.imaginary - other.imaginary)

    operator fun times(other: ComplexNumber) =
        ComplexNumber(
            real = this.real * other.real - this.imaginary * other.imaginary,
            imaginary = this.real * other.imaginary + this.imaginary * other.real
        )

    operator fun div(other: ComplexNumber) = times(other.reciprocal())

    override fun toString(): String {
        if (imaginary == 0.0) return real.toString()
        if (real == 0.0) return "${imaginary}i"

        return "$real+${imaginary}i"
    }
}
