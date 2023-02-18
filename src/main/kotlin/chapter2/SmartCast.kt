package chapter2

import kotlin.concurrent.thread

/*
=======================================================================
Expr Interface:
Expr 介面有兩個實作的 class: Num, Sum，
在 eval 中，要注意 else 的部分，compiler 會檢查有沒有預設的條件，
在這邊預設不能回傳任何數值，故直接 throw exception
=======================================================================

* */

/**
@author Yu-Jing
@create 2023/2/17 上午 11:52
 */

fun main() {

}

// 宣告 interface Expr，裡面沒有寫任何東西
interface Expr
// 定義 2 個 class, implement Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr
fun eval(e : Expr) : Int{
    if (e is Num) {
        //  cast the interface into implemented class (在 java 中是必要的，在 kotlin中則不用做)
        val num = e as Num
        return num.value
    }

    if (e is Sum) {
        // val sum = e as Sum 這一段是完全沒必要的! 因為 在 Kotlin 中，只要知道 e 是 Sum，那麼當你要調用 Sum 的方法時，
        // 他會自動幫你 cast，這個稱為 smart cast
        return  eval(e.left) + eval(e.right)
    }

    throw IllegalArgumentException("Unknown expression")
}

fun eval1(e : Expr) : Int {
    when (e) {
        is Num -> e.value
        is Sum -> eval1(e.left) + eval(e.right)
    }
    throw  IllegalArgumentException("Unknown expression")
}