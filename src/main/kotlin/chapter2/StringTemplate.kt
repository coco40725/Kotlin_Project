package chapter2

/**
@author Yu-Jing
@create 2023/2/17 上午 10:41
 */

fun main() {
    printName(arrayOf("Bob"));
    printName(arrayOf());
}

/**
 * Prints “Hello, Kotlin”, or
 * “Hello, Bob” if you pass
 * “Bob” as an argument
 */
fun printName(args : Array<String>){
    val name = if (args.size == 0) "Kotlin" else args[0];
    // 傳統寫法 println("Hello, " + name);
    // 以下使用 string template
    println("Hello, $name");
}

