package chapter2


/*
1. in Kotlin 中， class 的宣告
class [類名稱] (
 [權限] [var / val] [property名稱] : [property類型],
 [權限] [var / val] [property名稱] : [property類型],
) {...自訂內容}

當class 的 property 寫在 () 裡面基本上已經自動包含了:
    1. all properties "written in ()" constructor
    2. get() / set(value) (取決於是 var 還是 val，以及權限大小)

如果有些 property 你想要自訂其 get set method，或是寫一些 fun，
則是寫在 {} 這裡面。

=================================================================
2. Kotlin 中的權限包含: private、 protected、 internal 和 public ，
如果沒有指定，則是以 public 為預設

===============================================================
為了避免發生 fragile base class 問題，
kotlin 預設將 class, method 都加上 final 的特性，
如果要讓其他類別繼承的class 或覆寫的 method，
都必須要加上 open 這個 modifier

* */

/**
@author Yu-Jing
@create 2023/2/17 上午 10:49
 */


fun main(){
    val person = Person("小名", 12,23, true);
    // 相當於調用 get method
    println(person.age)
    println(person.name)
    println(person.isStudent)

    // 相當於調用 set method，注意，如果是 val 類型的變數，則無法再更換數值。
    // person.name = "123" 會直接error
    // person.age1 則因為 age1 是 private 無法調用
    person.age = 123
    println(person.age)

    val rectangle = Rectangle(12,23, "長方形")
    rectangle.printRect()
    println(rectangle.isSquare)
}

class Person (
    val name : String,
    var age : Int,
    private var age1 : Int,
    var isStudent : Boolean
)

open class Shape(val name : String)

class Rectangle(val height: Int, val width: Int, name: String) : Shape(name){
    // 自訂義 get  method
    val isSquare: Boolean
        get(){
            println("調用 get()")
            return height == width;
        }
        // 可以簡寫成 get() = height == width
    fun printRect() = println("這是長方形嗎?")
}