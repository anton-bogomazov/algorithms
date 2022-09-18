package problems

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class CoinChangeProblemKtTest {

    companion object {
        const val ARRAY_IS_EMPTY_ERROR = "Array is empty"
        const val INVALID_DENOMINATION_ERROR = "Denomination must be positive"
    }

    private val implementations = arrayOf(::countChange, ::countChangeWithHashmap, ::countChangeDP)

    @Test
    fun `countChange - success`() {
        val array = intArrayOf(1, 3, 5, 7)
        val target = 8

        implementations.forEach { f ->
            assertThat(f(array, target)).isEqualTo(6)
        }
    }

    @Test
    fun `countChange - success - not unique denominations`() {
        val array = intArrayOf(1, 1, 2, 3)
        val target = 4

        implementations.forEach { f ->
            assertThat(f(array, target)).isEqualTo(4)
        }
    }

    @Test
    fun `countChange - empty array`() {
        val array = intArrayOf()
        val target = 8

        implementations.forEach { f ->
            assertThatThrownBy { f(array, target) }.hasMessage(ARRAY_IS_EMPTY_ERROR)
        }
    }

    @Test
    fun `countChange - negative denominations`() {
        val array = intArrayOf(1, -2, 3)
        val target = 8

        implementations.forEach { f ->
            assertThatThrownBy { f(array, target) }.hasMessage(INVALID_DENOMINATION_ERROR)
        }
    }

    @Test
    fun `countChange - nil denomination`() {
        val array = intArrayOf(1, 0, 3)
        val target = 8

        implementations.forEach { f ->
            assertThatThrownBy { f(array, target) }.hasMessage(INVALID_DENOMINATION_ERROR)
        }
    }

}