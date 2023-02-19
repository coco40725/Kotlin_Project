package chapter4

/*
* 1. Properties in Kotlin classes can be declared either as mutable, using the var keyword, or as read-only, using the val keyword.
* 2. val and var 決定了 get / set method 的宣告與否
* 3. Backing field: In Kotlin, a field is only used as a part of a property to hold its value in memory. Fields cannot be declared directly.
* */

/**
@author Yu-Jing
@create 2023-02-19-上午 11:47
 */

fun main() {
    val school : School = School()
    println(school.tecNumber)
    school.tecNumber = 200
    println(school.tecNumber)
}
class School{
    val address : String = "台北市天龍國" // has type String  and initial value, default getter
    var stuNumber : Int = 100 // has type Int and initial value, default getter and setter

    var tecNumber : Int = 20
        get() {
            println("teacher getter is called")
            // 錯誤寫法: return this.tecNumber ， 這會造成遞迴
            return field // 這裡的 field 代表 property tecNumber 在 memory 的數值
        }

        set(value) {
            println("teacher setter is called")
            // 錯誤寫法: this.tecNumber = value ， 這會造成遞迴
            field = value // 這裡的 field 代表 property tecNumber  在 memory 的數值
        }
}