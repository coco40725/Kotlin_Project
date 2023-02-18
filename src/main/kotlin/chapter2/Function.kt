package chapter2
/*
1. 在 Kotlin Data Type:
Data types are divided into different groups:
-- Numbers :
    Integer types:  Byte, Short, Int and Long.
    Floating point types: Float and Double.

-- Characters: Char
-- Booleans : Boolean
-- Strings : String
-- Arrays: Array<>, arrayOf(...)

=================================================================================

2. 在 Kotlin 中，方法的定義方式:
寫法 1:
fun [方法名]([參數名] : [參數類型]) : [回傳類型]{
 方法體.....
}
例如:
fun main(args : Array<String>) {....} : 此相當於 java 的 main 方法
fun twoSum(first : Int, last : Int) : Int {....}

寫法 2:
fun [方法名]([參數名] : [參數類型]) : [回傳類型] = [Expression]

寫法 3: 進一步簡化寫法2，有回傳值，但直接透過 type inference 來推斷 Expression 的回傳值，並將其作為方法的回傳值。
fun [方法名]([參數名] : [參數類型])  = [Expression]

=================================================================================

3. Expression and Statement 介紹
3.1 Expression: 由 variable, operator, 方法呼叫 所組成，並且會回傳一個 value
                (簡單說你把 expression 放進 print function 中可以輸出東西)。
                例如:
                a = a + 1; println(a) 會出現一個數值
                a === 1;  println(a) 會出現 true or false

3.2 Statement: 執行一個指定的動作，不會回傳 value。
                if (a === true) {
                 doSomething();
                } else {
                 doSomethingElse();
                }

In Kotlin, most control structures, except for the loops (for, do, and do/
while) are expressions.
=================================================================================

* */

/**
@author Yu-Jing
@create 2023/2/17 上午 09:52
 */

fun main(args : Array<String>){
    println("Hello World!!");
    println(twoSum(1, 5));
    println(max(1, -1));
    println(max1(2, 9));
}

// 寫法 1:
fun twoSum(first : Int, last : Int) : Int{
    return first + last;
}

// 寫法 2:
fun max(first: Int, last: Int) :Int = if (first > last) first else last;

// 寫法 3:
fun max1(first: Int, last: Int) = if (first > last) first else last;