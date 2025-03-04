package com.app.listdatawithapi

import java.util.Collections


fun main() {
    //Find the largest/smallest element in an array.

    val numbers = listOf(10, 25, 5, 99, 1, 56, 1)

    val maxElement = numbers.maxOrNull() ?: "Array is empty" //numbers.max()
    val minElement = numbers.minOrNull() ?: "Array is empty" //numbers.min()

    println("Largest element: $maxElement") // Output: 99
    println("Smallest element: $minElement") // Output: 1


    val numbersD = listOf(1, 2, 3, 4, 5, 2, 3, 6, 7, 3)
    val duplicates = findDuplicates(numbersD)

    println("Duplicates: $duplicates") // Output: [2, 3]

    //Rotate an array by k positions (Cyclic rotation).

    val listRot = mutableListOf(1, 2, 3, 4, 5)
    val k = 2  // Rotate by 2 positions

    Collections.rotate(listRot, k)
    println(listRot) // Output: [4, 5, 1, 2, 3]


    //Swap two numbers without a third variable using an extension function
    var a=10
    var b=5

    a = b { b= a}
    println("A:: $a, B:: $b")

    //Find the most frequently occurring string in a list
    val mostOccurList = listOf("apple", "banana", "apple", "orange", "banana", "apple")
    val mostFrequent = mostFrequent(mostOccurList)
    println(mostFrequent) // Output: apple

    //Reverse a String Without Using Built-in Functions (Kotlin)
    val input = "hello world"
    println(reverseRecursively(input)) // Output: "dlrow olleh"

    //Find the missing number in an array
    val arr = mutableListOf(1, 2, 4, 6, 3, 7, 8)
    println("Missing number: ${findMissingNumberSort(arr)}") // Output: 5

    //Merge two sorted lists
    val list1 = listOf(1, 3, 5, 7)
    val list2 = listOf(2, 4, 6, 8)

    val mergedList = mergeSortedListsSimple(list1, list2)
    println(mergedList)  // Output: [1, 2, 3, 4, 5, 6, 7, 8]

    //implement a binary search algorithm
    val sortedList = listOf(1, 3, 5, 7, 9, 11, 15)
    val target = 7

    //implement a binary search algorithm
    val index = binarySearchRecursive(sortedList, target, 0, sortedList.size - 1)
    println("Element found at index: $index")  // Output: Element found at index: 3


    //Find the longest substring without repeating characters
    val inputRepeat = "abcabcbb"
    println("Longest substring length: ${longestSubstring(inputRepeat)}")  // Output: 3 ("abc")

}

//Find the most frequently occurring string in a list
fun mostFrequent(arr: List<String>): String?{
    return arr.groupingBy { it }.eachCount().maxByOrNull { it.value }?.key
}

//Find duplicates in an array.
fun findDuplicates(arr: List<Int>): Set<Int> {
    return arr.groupingBy { it }.eachCount().filter { it.value > 1 }.keys
}

//Swap two numbers without a third variable using an extension function
inline operator fun <T> T.invoke(dummy: () -> Unit): T {
    dummy()
    return this
}

//Reverse a String Without Using Built-in Functions (Kotlin)
fun reverseRecursively(str: String): String {
    if (str.isEmpty()) return str
    return reverseRecursively(str.drop(1)) + str.first()
}

//Find the missing number in an array
fun findMissingNumberSort(arr: MutableList<Int>): Int {
    arr.sort()
    for (i in arr.indices) {
        if (arr[i] != i + 1) return i + 1
    }
    return arr.size + 1
}

//Merge two sorted lists
fun mergeSortedListsSimple(list1: List<Int>, list2: List<Int>): List<Int> {
    return (list1 + list2).sorted()
}

//implement a binary search algorithm
fun binarySearchRecursive(arr: List<Int>, target: Int, left: Int, right: Int): Int {
    if (left > right) return -1  // Base case: Not found

    val mid = left + (right - left) / 2

    return when {
        arr[mid] == target -> mid  // Target found
        arr[mid] < target -> binarySearchRecursive(arr, target, mid + 1, right)  // Right half
        else -> binarySearchRecursive(arr, target, left, mid - 1)  // Left half
    }
}

//Find the longest substring without repeating characters
fun longestSubstring(s: String): Int =
    s.foldIndexed(mutableSetOf<Char>() to 0) { i, (set, maxLen), c ->
        while (!set.add(c)) set.remove(s[i - set.size])
        set to maxOf(maxLen, set.size)
    }.second



