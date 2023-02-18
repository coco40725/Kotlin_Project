package chapter2

/**
@author Yu-Jing
@create 2023/2/17 上午 11:11
 */

fun main() {
    println(Color.GREEN.rgb())
    Color.RED.hello()
}

enum class Color(var r : Int, var g : Int, var b : Int){
    RED(255,0,0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0);

    fun rgb() =  (r * 256 + g) * 256 + b
    fun hello() = println("顏色!")

}

enum class ColorSimple(){
    RED, ORANGE, YELLOW, GREEN
}