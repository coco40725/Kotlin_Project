package chapter2
/*
1. 在 Kotlin 中宣告變數
- val (from value): Immutable reference. A variable declared with val can’t be
    reassigned after it’s initialized. It corresponds to a final variable in Java.
    (初始化完就不可變，相當於 java final variable)

- var (from variable): Mutable reference. The value of such a variable can be
    changed. This declaration corresponds to a regular (non-final) Java variable.
    (初始化完後仍可變動，相當於java 一般變數)

在 Kotlin 中，變數的類型是寫在變數名稱之後 或 "有時"甚至不寫 (因為 Kotlin 可以進行 type inference):
val name : String = "大家好";
val name1 = "吃早餐";

* */


/**
@author Yu-Jing
@create 2023/2/17 上午 10:32
 */

fun main() {
    // 變數類型可寫可不寫
    val name : String = "大家好";
    val name1 = "吃早餐";
    println(name);
    println(name1);

    val salary : Double = 1e-3;
    val salary1 = 200.12;
    println(salary);
    println(salary1);

    // val 不可變, var 可變
    var food = "水果";
    food = "香蕉";
    println(food);

}