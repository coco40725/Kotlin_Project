package chapter3

/**
@author Yu-Jing
@create 2023/2/17 下午 04:38
 */
fun main() {
    val stu = Student()
    println(stu.speak())

    // 相當於 java 多型
    val person : Person = Student()
    println(person.speak())
    println(person.ability())

    val person2 : Person = Student()
    // 值得注意的是，這裡調用的是 person 的 method，而不是 student，
    // 因為 showName 是 extension method 而非 override method
    println(person2.showName()) // i am person
}
open class Person(){
    open fun speak() : String = "說話"
    fun ability() : String = "呼吸"
}

class Student : Person(){
    override fun speak() : String = "講幹話"
}

fun Person.showName() = println("i am person")
fun Student.showName() = println("i am student")