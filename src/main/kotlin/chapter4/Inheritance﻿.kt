package chapter4
/*
1. All classes in Kotlin have a common superclass, Any, which is the default superclass for a class with no supertypes declared.
2. By default, Kotlin classes are final – they can't be inherited. To make a class inheritable, mark it with the open keyword.
* */

/**
@author Yu-Jing
@create 2023-02-19-上午 11:31
 */

fun main() {
    val base : Base = Derived(123, "Derived")
    println(base.s)

    val base1 : Base = subClass(253, "base NAME", "OWN NAME")
}
open class Base(p: Int, val s : String = "base"){
    init {
        println("這是base init")
    }
}
/**
 * subclass with primary constructor:
 * If the derived class has a primary constructor, the base class can (and must) be initialized in that primary constructor according to its parameters.
 * */
class Derived (p : Int, s :String, val name : String = "subclass") : Base(p, s){
    init {
        println("Derived 的 property:  $s")
        println("subclass 自己的 property: $name")
    }
}

/**
 * subclass with secondary constructor:
 * If the derived class has no primary constructor, then each secondary constructor has to initialize the base type using the "super" keyword or it has to delegate to another constructor which does.
 * */
class subClass : Base{
    constructor(p : Int, s :String, name : String) : super(p, s){
        println("subclass 自己的 property: $name")
    }
}

/**
 * subclass with primary and  secondary constructor: base 的初始化必須在 primary constructor 完成!
 * */
class subClass2 (p : Int, s : String) : Base(p, s) {
    constructor(p : Int, s : String, name : String) : this (p, s){

    }
}