package problems

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MaxSumSubarrayKtTest {

    @Test
    fun `find maxSum - success`() {
        val array = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)

        assertThat(findMaxSumSubarray(array)).isEqualTo(6)
    }

    @Test
    fun `find maxSum - empty array`() {
        val array = intArrayOf()

        assertThat(findMaxSumSubarray(array)).isEqualTo(0)
    }

    @Test
    fun `find maxSum - only negatives`() {
        val array = intArrayOf(-2, -3, -1, -5)

        assertThat(findMaxSumSubarray(array)).isEqualTo(-1)
    }

}