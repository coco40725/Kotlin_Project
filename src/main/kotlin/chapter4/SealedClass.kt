package chapter4
/*
sealed class 是一個 abstract class ，本身並不能被 instantiate（實體化）。
但可以透過繼承某個 sealed class ，限縮可能的類型。
可以傳遞變數這種特性讓它可以作為進階版的 enum 使用，與 when語法配合後效果更佳。
* */

/**
@author Yu-Jing
@create 2023-02-19-上午 10:44
 */

sealed class Operation {
    class Add(val value: Int) : Operation()
    class Subtract(val value: Int) : Operation()
    class Multiply(val value: Int) : Operation()
    class Divide(val value: Int) : Operation()
}

fun execute(x: Int, op: Operation) = when (op) {
    is Operation.Add ->      x + op.value
    is Operation.Subtract -> x - op.value
    is Operation.Multiply -> x * op.value
    is Operation.Divide ->   x / op.value
}

fun main(args: Array<String>) {

    val result = execute(5, Operation.Subtract(3))
    println("result=$result")
    // result=2

}