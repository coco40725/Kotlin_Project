package chapter4

/*
It is not unusual to create classes whose main purpose is to hold data.
In such classes, some standard functionality and some utility functions are often mechanically derivable from the data.
使用 data class，以下的function 他會自動 override
1. equals()/hashCode() pair
2. toString() of the form "User(name=John, age=42)"
3. componentN() functions corresponding to the properties in their order of declaration.
4. copy() function (see below).

但是! 他只針對 primary constructor 所定義的 property 自動生成 function
The compiler only uses the properties defined inside the primary constructor for the automatically generated functions.

* **/

/**
@author Yu-Jing
@create 2023-02-19-下午 12:11
 */

fun main() {
    // data class
    val user = User("小美", 12)
    val user1 = User("小美", 12)
    println(user.equals(user1)) // true
    user.address = "台北"
    println(user.equals(user1)) // true ，因為 address 不屬於 primary constructor 的 property
    println(user) // user 內容
    val (name, age) = user // 可以使用 destructuring declarations

    // normal class
    val paper = Paper("研究", 123)
    val paper1 = Paper("研究", 123)
    println(paper.equals(paper1)) // false，因為我們沒有override equal
    println(paper) // hashcode

}

data class User(val name: String, val age: Int){
    var address : String =  ""
}
class Paper(val name : String, var price : Int)