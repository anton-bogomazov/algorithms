package data.structure.container.tree

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class BinarySearchTreeTest : StringSpec({

    "test insert" {
        val bst = BinarySearchTree()
        bst.insert(10)
        bst.insert(5)
        bst.insert(15)

        val iter = bst.BSTIterator()
        iter.next() shouldBe 5
        iter.next() shouldBe 10
        iter.next() shouldBe 15
    }

    "test delete" {
        val bst = BinarySearchTree()
        bst.insert(10)
        bst.insert(5)
        bst.insert(15)

        bst.delete(10)

        val iter = bst.BSTIterator()
        iter.next() shouldBe 5
        iter.next() shouldBe 15
        iter.hasNext shouldBe false
    }

    "test min" {
        val bst = BinarySearchTree()
        bst.insert(10)
        bst.insert(5)
        bst.insert(15)

        bst.min shouldBe 5
    }

})
