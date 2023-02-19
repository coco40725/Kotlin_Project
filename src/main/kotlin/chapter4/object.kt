package chapter4
/*
1. Object expressions create objects of anonymous classes,
 that is, classes that aren't explicitly declared with the class declaration. Such classes are useful for one-time use.
用於建立匿名式class

2. The Singleton pattern can be useful in several cases, and Kotlin makes it easy to declare singletons, by using Object declarations.
Companion 中文稱為「伴生」，在 kotlin 中，並沒有類似於 java 的 static 的修飾詞，所以如果你只想要一個 class 有靜態的成員或方法，而不是整個變成靜態的，
那就要採用 companion object 的寫法。基本上，可以將 companion object 區塊視為靜態。

而在 object 裡面的 property 與 function 都是靜態的，因此不用特別寫 companion object
**/

/**
@author Yu-Jing
@create 2023-02-19-下午 12:40
 */
fun main() {
    // Object expressions
    println(word)

    // Object declarations
    println(Robot.color)
    println(Robot.speak("你好"))

    // class with companion object
    println(RobotClass.color)
    println(RobotClass.speak("這是靜態的"))

}

val word = object {
    var first : String = "hello"
    var last : String = "world"
    override fun toString(): String {
        return "first: $first, last: $last"
    }
}

object Robot{
    var color: String= "white"
    fun speak(word : String) : String{
        return word
    }
}

class RobotClass{
    companion object {
        var color: String= "white"
        fun speak(word : String) : String{
            return word
        }
    }
}