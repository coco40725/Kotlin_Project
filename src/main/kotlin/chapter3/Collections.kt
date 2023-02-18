package chapter3
/*
Collection in Kotlin:
Kotlin uses the standard Java collection classes
https://kotlinlang.org/docs/collections-overview.html#collection-types

(Mutable 才能對集合進行更動，例如包含 add remove 的方法)

Collection Interface
1. List Interface
    -- MutableList Interface : ArrayList class (default), LinkedList class

2. Set Interface
    -- MutableSet Interface  : LinkedHashSet class (default) , HashSet class

Map Interface
    -- MutableMap Interface : LinkedHashMap class (default), HashMap class

* */

/**
@author Yu-Jing
@create 2023/2/17 下午 01:48
 */
fun main() {
    // list
    val list1 = listOf<Int>(1,2,3) // 不支援 write operations, such as add and remove
    val list2 = mutableListOf<Int>(1,2,3)
    val list3 = arrayListOf<Int>(1,2,3)
    println(list1.javaClass) // class java.util.Arrays$ArrayList
    println(list2.javaClass) // class java.util.ArrayList
    println(list3.javaClass) // class java.util.ArrayList

    // set
    val set1 = setOf<Int>(1,2)  // 不支援 write operations, such as add and remove
    val set2 = mutableSetOf<Int>(1,2,3)
    val set3 = hashSetOf<Int>(1,2,3)
    val set4 = linkedSetOf<Int>(1,23)
    println(set1.javaClass) // class java.util.LinkedHashSet
    println(set2.javaClass) // class java.util.LinkedHashSet
    println(set3.javaClass) // class java.util.HashSet
    println(set4.javaClass) // class class java.util.LinkedHashSet

    // map
    val map1 = mapOf<String, Int>("key1" to 1, "key2" to 3) // 不支援 write operations, such as map1["key1"] = 33
    val map2 = mutableMapOf<String, Int>("food" to 1, "car" to 2)
    val map3 = hashMapOf<String, Int>("apple" to 2, "banana" to 3)
    map3["apple"] = 33
    println(map1.javaClass) // class java.util.LinkedHashMap
    println(map2.javaClass) // class java.util.LinkedHashMap
    println(map3.javaClass) // class java.util.HashMap
}