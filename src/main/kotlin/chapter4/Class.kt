package chapter4
/*
1. Constructors
A class in Kotlin can have ONE primary constructor and ONE or MORE secondary constructors.
The primary constructor is a part of the class header, and it goes after the class name and optional type parameters.

 -- primary constructor:  The primary constructor is a part of the class header, and it goes after the class name and optional type parameters.

 -- secondary constructor: A class can also declare secondary constructors, which are prefixed with "constructor"
 */


/**
@author Yu-Jing
@create 2023-02-19-上午 10:46
 */

fun main() {
    // Primary Constructor
    val person = Person("小明")
    val person1 = Person()
    println(person.firstProperty)
    println(person1.firstProperty)
    println(person.personName)
    println(person1.personName)
    // person.name 是無法使用的，因為 name 不是 property

    val student = Student("小美", 95)
    // person1.name 可以使用，因為 name 是 property
    println(student.name)
    println(student.score)

    //------ Primary Constructor  ----------------------



    // Secondary Constructor
    val book = Book("恐怖小說")

    val journal = Journal(12.5, "Eleave")
    val journal1 = Journal(0.2, "China","掠奪性期刊")
    println(journal1.IFvalue)
    //------ Secondary Constructor  ----------------------


}

/**
 * primary constructor without property : name 不是 property!! 而是 parameter，且可以設定初始值
 * */
class Person(name : String = "default"){
    init {
        println("初始化 code block")
    }
    // property
    val firstProperty = "First property $name"
    val personName = name

}

/**
 * primary constructor with property : name 與 score 是 property 且可以設定初始值
 */
class Student(var name: String = "學生姓名", var score : Int){}


/**
 * secondary constructor without property: bookType 不是 property! 而是 parameter
 * */
class Book{
    constructor(bookType : String){
        println("this book type is $bookType")
    }
}

/**
 * secondary constructor with property IS NOT ALLOWED: constructor(val IFvalue : Double) {} 會報ERROR
 * */

/**
 * primary constructor + secondary constructor ， 每一個  secondary constructor parameter 都必須要囊括 primary 的 "Parameter 與 property" ， 並且 return primary constructor
 * */
class Journal(var IFvalue : Double, publisher : String){
    constructor(IFvalue : Double, publisher : String, name : String) : this(IFvalue, publisher){ // 這裡的 this 代表的是 primary constructor
        println("IFvalue : $IFvalue")
        println("publisher : $publisher")
        println("name : $name")
    }
}

