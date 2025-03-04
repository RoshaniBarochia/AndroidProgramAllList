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
class ListNode(var value: Int) {
    var next: ListNode? = null
}

fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr = head

    while (curr != null) {
        val next = curr.next  // Store next node
        curr.next = prev       // Reverse the link
        prev = curr            // Move prev to current node
        curr = next            // Move to next node
    }
    return prev  // New head of reversed list
}

fun printList(head: ListNode?) {
    var temp = head
    while (temp != null) {
        print("${temp.value} -> ")
        temp = temp.next
    }
    println("null")
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

    val reversedHead = reverseList(head)

    println("Reversed List:")
    printList(reversedHead)

    //2. Detect and remove a loop in a linked list.
    val headMul = ListNode(1)
    headMul.next = ListNode(2)
    headMul.next?.next = ListNode(3)
    headMul.next?.next?.next = ListNode(4)
    headMul.next?.next?.next?.next = ListNode(5)
    headMul.next?.next?.next?.next?.next = headMul.next // Creates a loop at node 2

    println("Detecting and Removing Loop...")
    detectAndRemoveLoop(headMul)

    println("Linked List after removing loop:")
    printList(headMul)

    //3. Find the middle node of a linked list.
    val headMiddle = ListNode(1)
    headMiddle.next = ListNode(2)
    headMiddle.next?.next = ListNode(3)
    headMiddle.next?.next?.next = ListNode(4)
    headMiddle.next?.next?.next?.next = ListNode(5) // Odd-length list

    printList(headMiddle)
    val middleNode = findMiddleNode(headMiddle)
    println("Middle Node: ${middleNode?.value}")

    // Example with an even-length list
    headMiddle.next?.next?.next?.next?.next = ListNode(6) // Even-length list

    printList(headMiddle)
    val middleNodeEven = findMiddleNode(headMiddle)
    println("Middle Node (Even): ${middleNodeEven?.value}")

    // 4. Merge two sorted linked lists.
    // Creating first sorted linked list: 1 -> 3 -> 5
    val l1 = ListNode(1)
    l1.next = ListNode(3)
    l1.next?.next = ListNode(5)

    // Creating second sorted linked list: 2 -> 4 -> 6
    val l2 = ListNode(2)
    l2.next = ListNode(4)
    l2.next?.next = ListNode(6)

    println("List 1:")
    printList(l1)

    println("List 2:")
    printList(l2)

    val mergedList = mergeTwoLists(l1, l2)
    println("Merged Sorted List:")
    printList(mergedList)
}


//2. Detect and remove a loop in a linked list.
fun detectAndRemoveLoop(head: ListNode?) {
    var slow = head
    var fast = head

    // Step 1: Detect the loop
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next

        if (slow == fast) { // Loop detected
            removeLoop(head, slow)
            return
        }
    }
}

// Step 2 & 3: Find the start of the loop and remove it
fun removeLoop(head: ListNode?, loopNode: ListNode?) {
    var ptr1 = head
    var ptr2 = loopNode

    while (ptr1?.next != ptr2?.next) {
        ptr1 = ptr1?.next
        ptr2 = ptr2?.next
    }

    ptr2?.next = null // Break the cycle
}

//3. Find the middle node of a linked list.
fun findMiddleNode(head: ListNode?): ListNode? {
    var slow = head
    var fast = head

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    return slow
}

// 4. Merge two sorted linked lists.
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummy = ListNode(0) // Dummy node as starting point
    var tail = dummy
    var first = l1
    var second = l2

    while (first != null && second != null) {
        if (first.value < second.value) {
            tail.next = first
            first = first.next
        } else {
            tail.next = second
            second = second.next
        }
        tail = tail.next!!
    }

    // Attach the remaining nodes of the non-empty list
    tail.next = first ?: second

    return dummy.next
}




