package problem.solving

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LongestCommonSubsequenceKtTest {

    private val implementations = arrayOf(::findLcsRecursion, ::findLcsRecursionWithHashMap, ::findLcsDP)

    @Test
    fun `find lcs - success`() {
        val firstSeq = "ABCBDAB"
        val secondSeq = "BDCABA"

        implementations.forEach { f ->
            assertThat(f(firstSeq, secondSeq)).isEqualTo(4)
        }
    }

    @Test
    fun `find lcs - no matches`() {
        val firstSeq = "ABCDE"
        val secondSeq = "FGKLO"

        implementations.forEach { f ->
            assertThat(f(firstSeq, secondSeq)).isEqualTo(0)
        }
    }

    @Test
    fun `find lcs - empty strings`() {
        val firstSeq = ""
        val secondSeq = ""

        implementations.forEach { f ->
            assertThat(f(firstSeq, secondSeq)).isEqualTo(0)
        }
    }

}
