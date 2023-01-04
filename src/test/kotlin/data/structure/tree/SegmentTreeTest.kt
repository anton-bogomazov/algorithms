package data.structure.tree

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class SegmentTreeTests : StringSpec({
    "test update" {
        val tree = SegmentTree(intArrayOf(1, 2, 3, 4, 5))
        tree.update(1, 8)
        tree.max(0, 3) shouldBe 8
    }

    "test update out of range" {
        val tree = SegmentTree(intArrayOf(1, 2, 3, 4))
        tree.update(3, 8)
        tree.max(0, 2) shouldBe 3
    }

    "test max" {
        val tree = SegmentTree(intArrayOf(1, 3, 2, 7, 9, 11))
        tree.max(0, 2) shouldBe 3
        tree.max(0, 5) shouldBe 11
    }

    "SegmentTree max" {
        val array = intArrayOf(1, 3, 2, 4, 5, 7, 6)
        val segmentTree = SegmentTree(array)

        segmentTree.max(0, 2) shouldBe 3
        segmentTree.max(1, 4) shouldBe 5
        segmentTree.max(3, 6) shouldBe 7
    }

    "single_element_array" {
        val array = intArrayOf(5)
        val segmentTree = SegmentTree(array)

        segmentTree.max(0, 0) shouldBe 5
    }

    "large_array" {
        val array = (1..1000).toList().toIntArray()
        val segmentTree = SegmentTree(array)

        segmentTree.max(0, 999) shouldBe 1000
    }

    "update_and_query" {
        val array = intArrayOf(1, 3, 2, 4, 5, 7, 6)
        val segmentTree = SegmentTree(array)

        segmentTree.update(3, 8)
        segmentTree.max(3, 6) shouldBe 8
    }

    "out_of_bounds" {
        val array = intArrayOf(1, 3, 2, 4, 5, 7, 6)
        val segmentTree = SegmentTree(array)

        segmentTree.max(-1, 2) shouldBe 3
        segmentTree.max(0, 10) shouldBe 7
    }

    "empty_array" {
        val array = intArrayOf()
        val segmentTree = SegmentTree(array)

        segmentTree.max(0, 0) shouldBe Int.MIN_VALUE
    }

    "update_out_of_bounds" {
        val array = intArrayOf(1, 3, 2, 4, 5, 7, 6)
        val segmentTree = SegmentTree(array)

        shouldThrow<IllegalArgumentException> { segmentTree.update(-1, 8) }
    }

    "max_range_length_one" {
        val array = intArrayOf(1, 3, 2, 4, 5, 7, 6)
        val segmentTree = SegmentTree(array)

        segmentTree.max(2, 2) shouldBe 2
    }

    "max_range_length_two" {
        val array = intArrayOf(1, 3, 2, 4, 5, 7, 6)
        val segmentTree = SegmentTree(array)

        segmentTree.max(1, 2) shouldBe 3
    }

    "max_range_length_three" {
        val array = intArrayOf(1, 3, 2, 4, 5, 7, 6)
        val segmentTree = SegmentTree(array)

        segmentTree.max(0, 2) shouldBe 3
    }

    "max_range_length_four" {
        val array = intArrayOf(1, 3, 2, 4, 5, 7, 6)
        val segmentTree = SegmentTree(array)

        segmentTree.max(0, 3) shouldBe 4
    }
})
