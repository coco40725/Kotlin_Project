package chapter3

import javax.swing.JToolBar.Separator

/**
@author Yu-Jing
@create 2023/2/17 下午 02:40
 */

fun main() {
    val list = listOf<String>("123", "456", "大家好")
    println(list)

    // 方法參數的寫法:
    // 寫法 1: 同java
    println(joinToString(list,"; ", "(",")"))
    // 寫法 2: 可以寫上 parameter 名稱
    println(joinToString(list, separator = ", ", prefix = "{", postfix = "}"))
    // 寫法 3: function parameter 可以填上 default value (java 不能填寫 default parameter)
    println(joinToString(list))

    countPlus()
    println(count)
}

// TOP-LEVEL PROPERTIES，所有 function 都讀的到
var count = 0
fun countPlus() = count ++

fun <T> joinToString (collection : Collection<T>,
                      separator: String = ";",
                      prefix : String = "{",
                      postfix : String = "}") : String {
    val word = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()){
        if (element != null) {
            word.append(element)
        }
        if (index != collection.size - 1){
            word.append(separator)
        }
    }
    word.append(postfix)
    return word.toString()
}