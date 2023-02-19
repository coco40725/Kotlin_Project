package chapter4
/*
* 1. An interface with only one abstract method is called a functional interface, or a Single Abstract Method (SAM) interface.
* 2. The functional interface can have several non-abstract members but only one abstract member.
* 3. To declare a functional interface in Kotlin, use the fun modifier.
* */

/**
@author Yu-Jing
@create 2023-02-19-上午 11:59
 */

fun main() {
    // Creating an instance of a class: 不使用 SAM conversions
    val myClass = object : EvenValue {
        override fun check(i: Int): Boolean = i % 2 == 0
    }
    println(myClass.check(123))

    // Creating an instance of a class: 使用 SAM conversions
    val myClass2 = EvenValue{i -> i % 2 == 0}
    println(myClass2.check(234))
}

fun interface EvenValue{
    fun check(i : Int) : Boolean
}

