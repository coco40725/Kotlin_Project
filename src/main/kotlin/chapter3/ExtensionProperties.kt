package chapter3
/*
注意!!! https://kotlinlang.org/docs/extensions.html
Extensions do NOT actually modify classes they extend !!
Since extensions do not actually insert members into classes,
there's no efficient way for an extension property to have a backing field.
This is why initializers are not allowed for extension properties.

Their behavior can only be defined by explicitly providing getters/setters.

 extension 並不是真的改動 class ， 所以一些 property field 或 property initializers 都是無法使用的
* */

/**
@author Yu-Jing
@create 2023-02-18-下午 05:03
 */

fun main() {
    val word = "你好"
    println(word.defaultWords)
    println(word.changeWords) // 調用 get
    word.changeWords = "123" // 調用 set

}

// 定義的一個 val extension property 到 string ， 必須定義 get 方法
val String.defaultWords : String
    get() = "這是預設文字"



// 定義一個 var extension property 到 string，必須定義 set / get 方法
var String.changeWords : String
    get() = "你好"
    set(value : String) {
        println("執行 set")
    }


// 自定義
// 必須使用 field 來避免遞迴
var myWord : String = ""
    get() = field
    set(value :String) {
        field = value
    }