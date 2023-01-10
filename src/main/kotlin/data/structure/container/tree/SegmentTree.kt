package data.structure.container.tree

import util.isOdd

class SegmentTree(array: IntArray) {

    private val initialArrayLength = array.size
    private val treeLastIndex = initialArrayLength - 1

    private var tree: IntArray = IntArray(initialArrayLength * 2)

    init {
        array.copyInto(tree, initialArrayLength)
        for (i in treeLastIndex downTo 1) {
            tree[i] = tree[2 * i].coerceAtLeast(tree[2 * i + 1])
        }
    }

    fun update(i: Int, value: Int) {
        if (i !in 0 until initialArrayLength) throw IllegalArgumentException("Index out of bounds")

        var arrayIndex = i + initialArrayLength
        tree[arrayIndex] = value

        while (arrayIndex > 1) {
            arrayIndex /= 2
            tree[arrayIndex] = tree[2 * arrayIndex].coerceAtLeast(tree[2 * arrayIndex + 1])
        }
    }

    fun max(from: Int, to: Int): Int {
        var from = if (from < 0) 0 else from
        var to = if (to > tree.lastIndex) tree.lastIndex else to
        var max = Int.MIN_VALUE

        from += initialArrayLength
        to += initialArrayLength

        while (from <= to) {
            if (from.isOdd()) {
                max = max.coerceAtLeast(tree[from])
            }
            if (!to.isOdd()) {
                max = max.coerceAtLeast(tree[to])
            }
            from = (from + 1) / 2
            to = (to - 1) / 2
        }

        return max
    }

}
