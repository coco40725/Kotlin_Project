package chapter3
/*
- The "vararg" keyword, which allows you to declare a function taking an arbitrary
number of arguments.

- An "infix" notation that allows "one-argument" functions to be called WITHOUT using the period and brackets.
Writing an infix function is a simple case of following three rules:
 1. The function is either defined on a class or is an extension method for a class (方法必須定義在 class 中)
 2. The function takes exactly ONE parameter (該方法只能有一個參數)
 3. The function is defined using the "infix keyword" (方法必須包含關鍵字 infix)

- "Destructuring declarations" that allow you to unpack a single composite value into multiple variables.
將一組數據分配到多個 variable，如果是自定義的class 需要撰寫 component1 等function

* */

/**
@author Yu-Jing
@create 2023-02-18-下午 06:28
 */

fun main() {
    myFun("123","456","785","111", title = "title")
    val food = Food("炸雞排", 60)
    println(food salePrice 0.85)

    val(name,price) = food
    println(name)
    println(price)

}

// vararg 相當於 java 參數的 "..."，代表參數數量不指定
// 但不同於 java， Kotlin 允許 vararg 寫在任何位置，因為 kotlin 支援指定參數
fun myFun(vararg words : String, title : String){
    println(title)
    for (str in words) {
        println(str)
    }
}

// infix: 單參數的方法呼叫時可以不用括弧
val map = mapOf(
    1 to "one", // infix call, 等價於 1.to("one")
    7 to "seven",  // infix call, 等價於 7.to("seven")
    53 to "fifty-three" // infix call, 等價於 53.to("fifty-three")
)

class Food(val name : String, val price : Int){
    infix fun salePrice(sale : Double) = this.price * sale
    operator fun component1(): Any {
        return this.name
    }
    operator fun component2(): Any{
        return this.price
    }
}