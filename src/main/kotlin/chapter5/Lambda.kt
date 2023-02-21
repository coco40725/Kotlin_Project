package chapter5
/*
1. Lambda expression
    1. 必然寫在 {} 裡面
    2. parameter 宣告在 {} 裡面，而 parameter 的 type 可寫可不寫
    3. function body 寫在 -> 之後
    4. 如果 return type 不是 Unit，則預設上 the last (or possibly single) expression inside the lambda body is treated as the return value.

**/
/**
@author Yu-Jing
@create 2023/2/21 下午 03:48
 */

fun main() {
    println(myLambdaFun(1, 2))
}

/**
 * basic lambda function
 * */
val myLambdaFun = {
    a : Int, b : Int ->
    a + 1
    b + 2
    a + b * 3
}

/**
 * it = 預設的變數名稱
 * */
val myVariable = {

}

