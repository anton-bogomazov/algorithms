package data.structure.container.tree

class BinarySearchTree : BinaryTree() {
    val min get() = min(root)

    fun delete(key: Int) {
        root = delete(root, key)
    }

    fun insert(key: Int) {
        root = insert(root, key)
    }

    private fun insert(node: TreeNode?, key: Int): TreeNode {
        if (node == null) return TreeNode(key)

        if (key < node.data) {
            node.left = insert(node.left, key)
        } else if (key > node.data) {
            node.right = insert(node.right, key)
        }

        return node
    }

    private fun delete(node: TreeNode?, key: Int): TreeNode? {
        if (node == null) return null

        if (key < node.data) {
            node.left = delete(node.left, key)
        } else if (key > node.data) {
            node.right = delete(node.right, key)
        } else {
            if (node.left == null) return node.right
            if (node.right == null) return node.left

            node.data = min(node.right)
            node.right = delete(node.right, node.data)
        }

        return node
    }

    private fun min(node: TreeNode?): Int {
        if (node == null) return 0

        var minValue: Int = node.data
        var currentNode: TreeNode? = node
        while (currentNode?.left != null) {
            minValue = currentNode.left!!.data
            currentNode = currentNode.left
        }

        // todo can I just return currentNode.left!!.data ?
        return minValue
    }
}
