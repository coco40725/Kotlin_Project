package chapter4
/*
in Kotlin, interface 可以包含 abstract method, 與 non-abstract method
* */

/**
@author Yu-Jing
@create 2023-02-18-下午 09:25
 */
interface Clickable {
    fun click()
    fun callName() = println("呼叫按鈕!")
}