package chapter2
/*
when 相當於 java 中的 switch
* */

/**
@author Yu-Jing
@create 2023/2/17 上午 11:31
 */

fun main() {
    println(getColorFood(Color.YELLOW))
    println(getColorFood(Color.GREEN))

    println(getColorTemp(Color.GREEN))
    println(getColorTemp(Color.RED))

    println(mixOptimized(Color.RED, Color.YELLOW))
    println(mixOptimized(Color.GREEN, Color.RED))
}

fun getColorFood(color: Color) =
    when (color){
        Color.RED -> "apple"
        Color.ORANGE -> "橘子"
        Color.YELLOW -> "香蕉"
        else -> "沒有ㄟ!"
    }
fun getColorTemp(color: Color) =
    when (color){
        // 可以一次放多個
        Color.RED, Color.YELLOW, Color.ORANGE -> "warm"
        else -> "i do not know!"
    }


// when without argument
fun mixOptimized(c1: Color, c2: Color) =
    when{
        (c1 == Color.RED || c2 == Color.YELLOW) -> "同色系的"
        else -> "怪怪個喔!"
    }
