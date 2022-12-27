package algorithm.list

import data.structure.list.Node

// Given a pointer to the head node of a linked list. Reverse this list.
// Worst case complexity time/space: O(n)/O(1)
fun <T> reverseList(list: Node<T>): Node<T> {
    var prev: Node<T>? = null
    var current: Node<T>? = list
    var next: Node<T>?

    while (current != null) {
        next = current.next
        current.next = prev
        prev = current
        current = next
    }
    return prev!!
}
