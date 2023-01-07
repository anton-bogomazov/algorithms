package problem

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class SkylineProblemKtTest : StringSpec({
    "test getSkyline with one building" {
        val buildings = arrayOf(intArrayOf(1, 5, 3))
        val expected = listOf(intArrayOf(1, 3), intArrayOf(5, 0))
        getSkyline(buildings) shouldBe expected
    }

    "test getSkyline with two non-overlapping buildings" {
        val buildings = arrayOf(intArrayOf(1, 5, 3), intArrayOf(7, 9, 4))
        val expected = listOf(intArrayOf(1, 3), intArrayOf(5, 0), intArrayOf(7, 4), intArrayOf(9, 0))
        getSkyline(buildings) shouldBe expected
    }

    "test getSkyline with two overlapping buildings" {
        val buildings = arrayOf(intArrayOf(1, 5, 3), intArrayOf(2, 8, 5))
        val expected = listOf(intArrayOf(1, 3), intArrayOf(2, 5), intArrayOf(8, 0))
        getSkyline(buildings) shouldBe expected
    }

    "test getSkyline with three buildings, one overlapping the other two" {
        val buildings = arrayOf(intArrayOf(1, 5, 3), intArrayOf(2, 8, 5), intArrayOf(3, 4, 4))
        val expected = listOf(intArrayOf(1, 3), intArrayOf(2, 5), intArrayOf(8, 0))
        getSkyline(buildings) shouldBe expected
    }

    "test getSkyline with abutting buildings same height" {
        val buildings = arrayOf(intArrayOf(0, 2, 3), intArrayOf(2, 5, 3), intArrayOf(5, 6, 3))
        val expected = listOf(intArrayOf(0, 3), intArrayOf(6, 0))
        getSkyline(buildings) shouldBe expected
    }

    "test getSkyline with abutting buildings increasing height" {
        val buildings = arrayOf(intArrayOf(0, 2, 3), intArrayOf(2, 5, 4), intArrayOf(5, 6, 5))
        val expected = listOf(intArrayOf(0, 3), intArrayOf(2, 4), intArrayOf(5, 5), intArrayOf(6, 0))
        getSkyline(buildings) shouldBe expected
    }

})
