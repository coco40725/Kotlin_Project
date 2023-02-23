package chapter6

import chapter4.School
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty

/*
1. 為何 "abc"::class 回傳的是 KClass<out String> 而非  KClass<String>
Remember that the type KClass<out T> means that its value represents either class T or any subclass of T, unlike the type KClass<T> which always means the class T.
When dealing with a value obj: T, you don’t know at compile time whether that value will have the class T or a subclass of T at runtime (因為多型),
therefore you can only assume that obj::class’s type is KClass<out T>.

udalov
JetBrains Team
(https://discuss.kotlinlang.org/t/can-i-get-kclass-t-for-instance-class/10974/4)

2.
- Class references : KClass<out T>,
    e.g. String::class, 則其 Type 為  KClass<out String>
- Function references : KFunction<out R> R代表的是 return type,
    e.g. p2::speak, 則其 Type 為 KFunction<out String>
- Property references: KProperty<R> R代表的是此 property的類型
    e.g. p1::name, 則其 Type 為 KProperty<out String>
- Constructor references:  KProperty<R>
    e.g. val myConstructor : () -> Person = ::Person, val p3 = myConstructor()
* **/

/**
@author Yu-Jing
@create 2023-02-23-下午 04:03
 */


fun main() {
    val p1 : Person = Person()
    val p11 : Person = Person("曉華","sss22323", 13)
    val p2 : Person = Student()
    // class references
    println(p1::class is KClass<out Person>) // true
    println(p2::class is KClass<out Person>) // true

    // Function references
    println(p2::speak is KFunction<out String>) // true

    // Property reference
    println(p1::name is KProperty<out String>) // true
    println(p1::name.getter is KFunction<out Any>) // true

    // Constructor references
    val myConstructor : () -> Person = ::Person
    println(myConstructor is  KFunction<*>) // true
    val p3 = myConstructor()
    println(p3 is Person) // true
}

open class Person(){
    // property
    var name : String = "default"
    var UID : String = "xxxxxxxx"
    var age : Int = 0

    // secondary constructor
    constructor(name : String, UID : String, age : Int) : this(){
        this.name = name
        this.age = age
        this.UID = UID
    }

    fun speak(word : String) = word
}

class Student() : Person(){
    // property
    var school = "天龍國小"

    // secondary constructor
    constructor(school : String) : this(){
        this.school = school
    }
}

class Student1(name : String, UID: String, age: Int) : Person(name, UID, age){
    // property
    var school = "天龍國小"

    // secondary constructor
    constructor(school : String, name : String, UID: String, age: Int) : this(name, UID, age) {
        this.school = school
    }
}
