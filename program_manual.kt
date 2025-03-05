package com.app.listdatawithapi

import java.util.Arrays


fun main() {

    //Find the largest/smallest element in an array.
    val numbers = intArrayOf(10, 25, 5, 99, 1, 56)
    val (min, max) = findMinMax(numbers)

    println("Largest element: $max") // Output: 99
    println("Smallest element: $min") // Output: 1


    //Find duplicates in an array.
    val numbersD = intArrayOf(1, 2, 3, 4, 5, 2, 3, 6, 7, 3)
    val duplicates = findDuplicates(numbersD)

    println("Duplicates: $duplicates") // Output: [2, 3]

    //Reverse an array without using extra space.
    val reverseArr = mutableListOf(23,45,67,89,43,76,77)
    reverseArray(reverseArr)
    println(reverseArr)


    //Rotate an array by k positions.
    val rotList= mutableListOf(10,20,30,40,50,60,70,80,90)
    val pos=3
    val outputList= rotateListByPos(pos,rotList)
    println(outputList)

    //Swap two numbers without a third variable using an extension function
    var a=10
    var b=5

    a = b.swap{ b= a}
    println("A:: $a, B:: $b")

    //second program of swapping value
    val num1 = Mutable(4)
    val num2 = Mutable(6)

    println("Before Swapping:-\n\tNumber#1 is: $num1\n\tNumber#2 is: $num2\n")

    //calling way of class method is not like usual swap function
    //num1 swapWith num2
    //calling the actual swap function.
    swap(num1, num2)

    println("After Swapping:-\n\tNumber#1 is: $num1\n\tNumber#2 is: $num2\n")

    //Find the most frequently occurring string in a list
    val mostOccurList = listOf("apple", "banana", "apple", "orange", "banana", "apple")
    val hashmap = HashMap<String,Int>()
    for(i in mostOccurList.indices){
        if(hashmap.contains(mostOccurList[i])){
            hashmap[mostOccurList[i]] = hashmap[mostOccurList[i]]!! + 1

        }else
            hashmap[mostOccurList[i]] = 1
    }
    var gre=0
    for((k,v) in hashmap){
        if(gre < v){
            gre=v
        }
    }
    val f= hashmap.filterValues{ it == gre}
    println(f.keys)

    //Reverse a String Without Using Built-in Functions (Kotlin)
    val input = "hello world"
    println(reverseString(input)) // Output: "dlrow olleh"

    //Check if a String is a Palindrome in Kotlin
    println(isPalindrome("madam"))  // true

    //Find the missing number in an array
    val arr = listOf(1, 2, 4, 6, 3, 7, 8)
    println("Missing number: ${findMissingNumber(arr)}") // Output: 5

    //Merge two sorted lists
    val list1 = listOf(1, 3, 5, 7)
    val list2 = listOf(2, 4, 6, 8)

    //Merge two sorted lists
    val mergedList = mergeSortedLists(list1, list2)
    println(mergedList)  // Output: [1, 2, 3, 4, 5, 6, 7, 8]

    //Implement a binary search algorithm
    val sortedList = listOf(1, 3, 5, 7, 9, 11, 15)
    val targetSortNo = 7

    //implement a binary search algorithm
    val index = binarySearch(sortedList, targetSortNo)
    println("Element found at index: $index")  // Output: Element found at index: 3

    //Find the longest substring without repeating characters
    val inputRepeat = "abcabcbb"
    println("Longest substring length: ${longestUniqueSubstring(inputRepeat)}")  // Output: 3 ("abc")

    //Find missing numbers in an array (consecutive or non-consecutive).
    //1.Consecutive Missing Numbers
    val arrMissing = intArrayOf(1, 2, 4, 5, 6) // N = 6, missing 3
    println("Missing number: ${findMissingNumber(arrMissing, arrMissing.size+1)}") // Output: 3

    //2. Non-Consecutive Missing Numbers
    val arrNonCon = intArrayOf(1, 3, 5, 7, 9) // Missing: 2, 4, 6, 8, 10
    println("Missing numbers: ${findAllMissingNumbers(arrNonCon, 1, 10)}") // Output: [2, 4, 6, 8, 10]


    //Find pairs that sum up to a given number.
    val arrFindPairs = intArrayOf(1, 4, 6, 8, 3, 7, 2)
    val targetFindPair = 10
    findPairs(arrFindPairs, targetFindPair)
    findPairsUsingSet(arrFindPairs, targetFindPair)

    //Implement two-pointer technique.
    //1️⃣ Checking If a Given Array is a Palindrome
    val arrPalindrome = intArrayOf(1, 2, 3, 2, 1)
    println(isPalindrome(arrPalindrome))  // Output: true

    //2️⃣ Find Two Elements Whose Difference is a Given Value
    val arrDiff = intArrayOf(1, 3, 5, 8, 12, 15)  // Sorted array
    findPairWithDifference(arrDiff, 7)  // Output: Pair: (5, 12)


    //3️⃣ Move Zeros to End
    val arrZero = intArrayOf(0, 1, 0, 3, 12, 0)
    moveZerosToEnd(arrZero)
    println(arr.joinToString())  // Output: 1, 3, 12, 0, 0, 0

    //Longest palindromic substring.
    val inputSubString = "babad"
    println(longestPalindrome(inputSubString))  // Output: "bab" or "aba"


    //Check if two strings are anagrams.
    println(anagramString())

    //Find the longest common prefix of an array of strings.
    val strArr= arrayOf("flower","flow","flight")
    println(longestCommonPrefixInArray(strArr))
}

//Find the largest/smallest element in an array.
fun findMinMax(arr: IntArray): Pair<Int, Int> {
    var max = arr[0]
    var min = arr[0]

    for (num in arr) {
        if (num > max) max = num
        if (num < min) min = num
    }
    return Pair(min, max)
}

//Reverse a String Without Using Built-in Functions (Kotlin)
fun reverseString(str: String): String {
    val charArray = str.toCharArray()
    var left = 0
    var right = str.length - 1

    while (left < right) {
        // Swap characters
        val temp = charArray[left]
        charArray[left] = charArray[right]
        charArray[right] = temp

        left++
        right--
    }
    return String(charArray)
}

//Find duplicates in an array.
fun findDuplicates(arr: IntArray): Set<Int> {
    val freqMap = mutableMapOf<Int, Int>()
    val duplicates = mutableSetOf<Int>()

    for(i in arr){
        freqMap[i]=freqMap.getOrDefault(i,0)+1
        if(freqMap[i]!! > 1){
            duplicates.add(i)
        }
    }
    return duplicates

}

//Reverse an array without using extra space.
fun reverseArray(arr: MutableList<Int>){
    var left = 0
    var right=(arr.size)-1
    while(left < right){
        arr[left] = arr[right].also { arr[right] = arr[left] }
        left++
        right--
    }
}

//Rotate an array by k positions (Cyclic rotation).
fun rotateListByPos(pos : Int,list:MutableList<Int>): MutableList<Int>{
    val outputList= mutableListOf<Int>()
    for(i in pos until list.size){
        outputList.add(list[i])
    }
    for(i in 0 until pos){
        outputList.add(list[i])
    }
    return outputList
}

//Swap two numbers without a third variable using an extension function
inline fun <T> T.swap(swapSecond: () -> Unit): T{
    swapSecond()
    return this
}

//Swap two numbers without a third variable using an extension function
fun <T> swap(num1: Mutable<T>, num2: Mutable<T>) {
    num1.value = num2.value.also { num2.value = num1.value }
}
class Mutable<T>(var value: T) {
    override fun toString() = value.toString()

    /**
    infix fun swapWith(other: Mutable<T>) {
    value = other.value.also { other.value = value }
    }
     **/
}

//Check if a String is a Palindrome in Kotlin
fun isPalindrome(str: String): Boolean {
    val cleanedStr = str.replace("\\s".toRegex(), "").lowercase() // Remove spaces & convert to lowercase
    var left = 0
    var right = cleanedStr.length - 1

    while (left < right) {
        if (cleanedStr[left] != cleanedStr[right]) return false
        left++
        right--
    }
    return true
}

//Find the missing number in an array
fun findMissingNumber(arr: List<Int>): Int {
    val n = arr.size + 1 // Since one number is missing
    val expectedSum = (n * (n + 1)) / 2
    val actualSum = arr.sum()
    return expectedSum - actualSum
}

//Merge two sorted lists
fun mergeSortedLists(list1: List<Int>, list2: List<Int>): List<Int> {
    val mergedList = mutableListOf<Int>()
    var i = 0
    var j = 0

    while (i < list1.size && j < list2.size) {
        if (list1[i] < list2[j]) {
            mergedList.add(list1[i])
            i++
        } else {
            mergedList.add(list2[j])
            j++
        }
    }

    // Add remaining elements
    while (i < list1.size) {
        mergedList.add(list1[i])
        i++
    }

    while (j < list2.size) {
        mergedList.add(list2[j])
        j++
    }

    return mergedList
}

//implement a binary search algorithm
fun binarySearch(arr: List<Int>, target: Int): Int {
    var left = 0
    var right = arr.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2  // Prevents overflow

        when {
            arr[mid] == target -> return mid  // Target found
            arr[mid] < target -> left = mid + 1  // Search right half
            else -> right = mid - 1  // Search left half
        }
    }

    return -1  // Target not found
}

//Find the longest substring without repeating characters
fun longestUniqueSubstring(s: String): Int {
    val seen = mutableSetOf<Char>()
    var left = 0
    var maxLength = 0

    for (right in s.indices) {
        while (s[right] in seen) {
            seen.remove(s[left])
            left++
        }
        seen.add(s[right])
        maxLength = maxOf(maxLength, right - left + 1)
    }

    return maxLength
}

//Find missing numbers in an array (consecutive or non-consecutive).
//1. Consecutive Missing Numbers
fun findMissingNumber(arr: IntArray, n: Int): Int {
    val expectedSum = (n * (n + 1)) / 2
    val actualSum = arr.sum()
    return expectedSum - actualSum
}

//2. Non-Consecutive Missing Numbers
fun findAllMissingNumbers(arr: IntArray, low: Int, high: Int): List<Int> {
    val set = arr.toSet()
    return (low..high).filter { it !in set }
}

//Find pairs that sum up to a given number.
fun findPairs(arr: IntArray, target: Int) {
    for (i in arr.indices) {
        for (j in i + 1 until arr.size) {
            if (arr[i] + arr[j] == target) {
                println("Pair: (${arr[i]}, ${arr[j]})")
            }
        }
    }
}
fun findPairsUsingSet(arr: IntArray, target: Int) {
    val seen = mutableSetOf<Int>()
    for (num in arr) {
        val complement = target - num
        if (complement in seen) {
            println("Pair: ($complement, $num)")
        }
        seen.add(num)
    }
}

//Implement two-pointer technique.
//1️⃣ Checking If a Given Array is a Palindrome
fun isPalindrome(arr: IntArray): Boolean {
    var left = 0
    var right = arr.size - 1

    while (left < right) {
        if (arr[left] != arr[right]) {
            return false
        }
        left++
        right--
    }
    return true
}

//2️⃣ Find Two Elements Whose Difference is a Given Value
fun findPairWithDifference(arr: IntArray, target: Int) {
    var left = 0
    var right = 1

    while (right < arr.size) {
        val diff = arr[right] - arr[left]
        when {
            diff == target -> {
                println("Pair: (${arr[left]}, ${arr[right]})")
                return
            }
            diff < target -> right++
            else -> left++
        }
    }
    println("No pair found")
}

//3️⃣Move Zeros to End
fun moveZerosToEnd(arr: IntArray) {
    var left = 0

    for (right in arr.indices) {
        if (arr[right] != 0) {
            arr[left] = arr[right].also { arr[right] = arr[left] }  // Swap
            left++
        }
    }
}

//Longest palindromic substring.
fun longestPalindrome(s: String): String {
    if (s.isEmpty()) return ""

    var start = 0
    var end = 0

    for (i in s.indices) {
        val len1 = expandFromCenter(s, i, i)     // Odd length palindrome
        val len2 = expandFromCenter(s, i, i + 1) // Even length palindrome
        val maxLen = maxOf(len1, len2)

        if (maxLen > end - start) {
            start = i - (maxLen - 1) / 2
            end = i + maxLen / 2
        }
    }
    return s.substring(start, end + 1)
}

fun expandFromCenter(s: String, left: Int, right: Int): Int {
    var l = left
    var r = right

    while (l >= 0 && r < s.length && s[l] == s[r]) {
        l--
        r++
    }
    return r - l - 1 // Length of the palindrome
}

//Check if two strings are anagrams.
fun anagramString(): Boolean{

    val str1= "brainy"
    val str2 = "binary"

    val arr1=str1.toCharArray()
    val arr2=str2.toCharArray()
    Arrays.sort(arr1)
    Arrays.sort(arr2)
    val sort1=String(arr1)
    val sort2=String(arr2)

    return sort1 == sort2
}

//Find the longest common prefix of an array of strings.
fun longestCommonPrefixInArray(strs: Array<String>): String {
    if (strs.size == 0) return ""
    var len = 0
    var res = ""
    for (j in 0 until strs[0].length) {
        val c = strs[0][j]
        for (i in 1 until strs.size) {
            if (j >= strs[i].length || strs[i][j] != c) {
                return res
            }
        }
        res += c
    }
    return res
}










