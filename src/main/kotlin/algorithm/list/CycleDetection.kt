package algorithm.list

import data.structure.primitive.Node

// Floyd’s Cycle Detection Algorithm
// Move two pointers with different speed. If there is a cycle - they will point at same node.
// Worst case complexity time/space: O(n)/O(1)
fun <T> cycleDetection(list: Node<T>): Boolean {
    var slow = list
    var fast: Node<T>? = list

    while (fast?.next != null) {
        slow = slow.next!!
        fast = fast.next!!.next

        if (slow == fast) return true
    }

    return false
}
