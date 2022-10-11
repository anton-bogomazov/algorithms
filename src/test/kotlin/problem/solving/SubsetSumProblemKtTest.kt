package problem.solving

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SubsetSumProblemKtTest {

    private val implementations = arrayOf(::findSubset, ::findSubsetWithHashmap, ::findSubsetDP)

    @Test
    fun `find subset - success`() {
        val array = intArrayOf(7, 3, 2, 5, 8)
        val target = 14

        implementations.forEach { f ->
            assertThat(f(array, target)).isEqualTo(true)
        }
    }
}
