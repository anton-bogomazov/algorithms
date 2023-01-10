package data.structure.container.tree

import java.util.*
import kotlin.math.abs

open class BinaryTree(protected var root: TreeNode? = null) {
    val height get() = height(root)
    val levels get() = levels(root)
    val isBalanced get() = isBalanced(root)

    private fun levels(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val result: List<MutableList<Int>> = (0 until height).map { mutableListOf() }
        val queue: Queue<Pair<TreeNode, Int>> = LinkedList()

        queue.add(Pair(root, 0))

        while (!queue.isEmpty()) {
            val (node, level) = queue.poll()
            result[level].add(node.data)
            node.left?.let { queue.add(it to level + 1) }
            node.right?.let { queue.add(it to level + 1) }
        }

        return result
    }

    private fun isBalanced(node: TreeNode?): Boolean {
        if (node == null) return true

        return abs(height(node.left) - height(node.right)) <= 1
                && isBalanced(node.left) && isBalanced(node.right)
    }

    private fun height(node: TreeNode?): Int {
        if (node == null) return 0

        val lDepth = height(node.left)
        val rDepth = height(node.right)

        return if (lDepth > rDepth) lDepth + 1 else rDepth + 1
    }

    data class TreeNode(var data: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    inner class BSTIterator {
        private val stack: Stack<TreeNode> = Stack()
        val hasNext get() = stack.isNotEmpty()

        init {
            var currentNode = root
            while (currentNode != null) {
                stack.push(currentNode)
                currentNode = currentNode.left
            }
        }

        fun current() = stack.peek().data

        fun next(): Int {
            val next = stack.pop()

            var temp = next.right
            while (temp != null) {
                stack.push(temp)
                temp = temp.left
            }

            return next.data
        }
    }
}
