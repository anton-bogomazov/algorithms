package algorithm.list

import data.structure.primitive.Node
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ReverseListKtTest : StringSpec({

    "should reverse a linked list" {
        val head = Node(1)
        head.next = Node(2)
        head.next!!.next = Node(3)
        head.next!!.next!!.next = Node(4)
        head.next!!.next!!.next!!.next = Node(5)

        val reversed = reverseList(head)

        reversed.data shouldBe 5
        reversed.next!!.data shouldBe 4
        reversed.next!!.next!!.data shouldBe 3
        reversed.next!!.next!!.next!!.data shouldBe 2
        reversed.next!!.next!!.next!!.next!!.data shouldBe 1
    }

})
