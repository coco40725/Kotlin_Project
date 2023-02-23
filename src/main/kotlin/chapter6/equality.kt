package chapter6

/**
@author Yu-Jing
@create 2023-02-23-下午 02:31
 */
/**
 * Structural equality (== - a check for equals())
 * Referential equality (=== - two references point to the same object)
 * */

fun main() {
    val a = "123"
    val b = "123"
    println(a == b) // true
    println(a === b) // true, since the string pool

    val c = listOf<Int>(1,2,2)
    val d = listOf<Int>(1,2,2)
    println(c == d) // true
    println(c === d) // false

}

