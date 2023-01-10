package data.structure.container.tree

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class BinaryTreeTest : StringSpec({
    "height() method" {
        tree().height shouldBe 3
    }

    "levels() method" {
        tree().levels shouldBe listOf(
            listOf(1),
            listOf(2, 3),
            listOf(4, 5, 6)
        )
    }

    "isBalanced() method" {
        tree().isBalanced shouldBe true
    }
})

//     1
//   / \
//  2   3
// / \ /
//4  5 6
private fun tree(): BinaryTree {
    val root = BinaryTree.TreeNode(1)
    val node2 = BinaryTree.TreeNode(2)
    val node3 = BinaryTree.TreeNode(3)
    val node4 = BinaryTree.TreeNode(4)
    val node5 = BinaryTree.TreeNode(5)
    val node6 = BinaryTree.TreeNode(6)

    root.left = node2
    root.right = node3
    node2.left = node4
    node2.right = node5
    node3.left = node6

    return BinaryTree(root)
}
