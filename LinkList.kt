package com.app.listdatawithapi

/**
 * Linked List:
 * 1. Reverse a singly linked list.
 * 2. Detect and remove a loop in a linked list.
 * 3. Find the middle node of a linked list.
 * 4. Merge two sorted linked lists.
 *
 * */

// 1. Reverse a singly linked list.
fun reverseListRecursive(head: ListNode?): ListNode? {
    if (head == null || head.next == null) return head

    val newHead = reverseListRecursive(head.next)
    head.next!!.next = head
    head.next = null

    return newHead
}

fun main() {
    // 1. Reverse a singly linked list.

    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)

    println("Original List:")
    printList(head)

    val reversedHead = reverseListRecursive(head)

    println("Reversed List (Recursive):")
    printList(reversedHead)
}
