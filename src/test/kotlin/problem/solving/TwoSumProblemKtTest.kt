package problem.solving

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

class TwoSumProblemKtTest {

    companion object {
        private const val PAIR_NOT_FOUND_ERROR = "Pair not found"
    }

    private val implementations = arrayOf(::findPairBruteforce, ::findPairTwoPointers, ::findPairWithSet)

    @Test
    fun `find pair - success`() {
        val nums = intArrayOf(8, 7, 2, 5, 3, 1, 10, 151)
        val target = 154

        implementations.forEach { f ->
            assertThat(f(nums, target)).isEqualTo(3 to 151)
        }
    }

    @Test
    fun `find pair - error`() {
        val nums = intArrayOf(8, 7, 2, 5, 3, 1, 10)
        val target = 154

        implementations.forEach { f ->
            assertThatThrownBy { f(nums, target) }.hasMessage(PAIR_NOT_FOUND_ERROR)
        }
    }

    @Test
    fun `find pair - empty array`() {
        val nums = intArrayOf()
        val target = 154

        implementations.forEach { f ->
            assertThatThrownBy { f(nums, target) }.hasMessage(PAIR_NOT_FOUND_ERROR)
        }
    }

}
