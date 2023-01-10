package problem.linkedlist

import data.structure.primitive.Node

fun <T> removeNthFromEnd(head: Node<T>, n: Int): Node<T>? {
    if (head.next == null && n == 1) return null
    var pointer = head

    repeat(n) {
        val nextNode = pointer.next
        if (nextNode == null) {
            return head.next
        } else {
            pointer = nextNode
        }
    }

    var nodeToRemove = head
    while (pointer.next != null) {
        pointer = pointer.next!!
        nodeToRemove = nodeToRemove.next!!
    }

    nodeToRemove.next = nodeToRemove.next!!.next

    return head
}
