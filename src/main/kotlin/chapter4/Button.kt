package chapter4

/**
@author Yu-Jing
@create 2023-02-18-下午 09:27
 */

fun main() {
    Button().click()
    Button().callName()
}
class Button : Clickable{
    override fun click() {
        println("按下去")
    }
}

// 如果 implement 的 interfaces 有同樣的方法 (完全一樣，包含參數等等)，則要 override
class Button1 : Clickable, Focusable{
    override fun click() {
        println("按下去?")
    }

    override fun callName() {
        super<Clickable>.callName()
    }
}