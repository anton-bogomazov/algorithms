package algorithm.list

import data.structure.list.Node
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CycleDetectionKtTest : StringSpec({

    "should detect a cycle in a linked list" {
        // set up a linked list with a cycle
        val head = Node(1)
        val second = Node(2)
        val third = Node(3)
        val fourth = Node(4)
        head.next = second
        second.next = third
        third.next = fourth
        fourth.next = second

        // check if the function detects a cycle in the linked list
        cycleDetection(head) shouldBe true
    }

    "should not detect a cycle in a linked list" {
        // set up a linked list with no cycle
        val head = Node(1)
        val second = Node(2)
        val third = Node(3)
        val fourth = Node(4)
        head.next = second
        second.next = third
        third.next = fourth

        // check if the function detects a cycle in the linked list
        cycleDetection(head) shouldBe false
    }

})
