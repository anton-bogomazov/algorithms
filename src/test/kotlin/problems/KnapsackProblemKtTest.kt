package problems

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class KnapsackProblemKtTest {

    private val implementations = arrayOf(::collectKnapsack, ::collectKnapsackWithHashmap, ::collectKnapsackDP)

    @Test
    fun `collect knapsack - success`() {
        val items = listOf(20 to 1, 5 to 2, 10 to 3, 40 to 8, 15 to 7, 25 to 4)
        val capacity = 10

        implementations.forEach { f ->
            assertThat(f(items, capacity)).isEqualTo(60)
        }
    }

}