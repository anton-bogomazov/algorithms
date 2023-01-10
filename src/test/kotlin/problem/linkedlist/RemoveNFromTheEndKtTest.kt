package problem.linkedlist

import data.structure.primitive.Node
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RemoveNFromTheEndKtTest : StringSpec({

    "removeNthFromEnd" {
        val head = Node(1)
        val second = Node(2)
        val third = Node(3)
        val fourth = Node(4)
        head.next = second
        second.next = third
        third.next = fourth

        val result = removeNthFromEnd(head, 2)

        result shouldBe head
        result!!.next shouldBe second
        result!!.next!!.next shouldBe fourth
        result!!.next!!.next!!.next shouldBe null
    }

    "removeNthFromEnd last element" {
        val head = Node(1)
        val second = Node(2)
        val third = Node(3)
        val fourth = Node(4)
        head.next = second
        second.next = third
        third.next = fourth

        val result = removeNthFromEnd(head, 1)

        result shouldBe head
        result!!.next shouldBe second
        result!!.next!!.next shouldBe third
        result!!.next!!.next!!.next shouldBe null
    }

    "removeNthFromEnd first element" {
        val head = Node(1)
        val second = Node(2)
        val third = Node(3)
        val fourth = Node(4)
        head.next = second
        second.next = third
        third.next = fourth

        val result = removeNthFromEnd(head, 4)

        result shouldBe second
        result!!.next shouldBe third
        result!!.next!!.next shouldBe fourth
        result!!.next!!.next!!.next shouldBe null
    }

    "removeNthFromEnd one elem" {
        val head = Node(1)

        val result = removeNthFromEnd(head, 1)

        result shouldBe null
    }

})
