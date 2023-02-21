package chapter5
/*
* infix function 條件
* 1. 只有一個 parameter
* 2. 該 function 必須屬於某個 class 的 member 或是 屬於 extension function
* 3. 該 parameter 不能有 default value
* 4. 該 parameter 不可以是 varags
* 寫法: [object] [infix fun] [one parameter]
* */

/**
@author Yu-Jing
@create 2023/2/21 上午 11:14
 */

fun main() {
    val p = Person()
    p speak "吃午餐"
}
class Person{
    infix fun speak(word : String){
        println(word)
    }
}
