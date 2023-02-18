package chapter3

/*
an extension function is a simple thing: it’s a function that can be
called as a member of a class but is defined outside of it.
基於已被建立好的 class 上，插入一個 自定義 method 作為其 member， 但不代表可以通用於整個專案中，
如果想要在其他 package使用，則需要 import。

例如: chapter2 ExtensionMethods1.kt，
必須寫 import chapter3.myFun

* */
/**
@author Yu-Jing
@create 2023/2/17 下午 04:12
 */

fun main() {
    println("myWord".myFun())
    println("HelloWorld".lastChar())
    val list = listOf<String>("123", "Hello")
    println(list.joinToString())
}

// 在 String class (java 本身的 class) 插入一個 自訂義 method
fun String.myFun() : String {
    return "myFun 大家好"
}

fun String.lastChar() : Char = this.get(this.length - 1)

// 在 Collection interface 中 添加一個方法 joinToString
fun <T> Collection<T>.joinToString(separator: String = "; ",
                                   prefix : String = "{",
                                   postfix : String = "}") : String {
    val word = StringBuilder(prefix)
    for ((index, element) in this.withIndex()){
        if (element != null) {
            word.append(element)
        }
        if (index != this.size - 1){
            word.append(separator)
        }
    }
    word.append(postfix)
    return word.toString()
}
