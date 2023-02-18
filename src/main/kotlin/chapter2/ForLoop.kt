package chapter2
/**
@author Yu-Jing
@create 2023/2/17 下午 01:38
 */

fun main() {
    for (i in 1..100){
        println(fizzBuzz(i))
    }

    for (s in arrayOf("你好", "這裡是?" , "我是誰")) {
        println(s)
    }

    for ((index, name) in arrayOf("香蕉", "西瓜").withIndex()){
        println("$index : $name")
    }

}

fun fizzBuzz(i: Int) =
    when {
        i % 15 == 0 -> "FizzBuzz"
        i % 5 == 0 -> "Buzz"
        i % 3 == 0 -> "Fizz"
        else -> "$i"
    }
