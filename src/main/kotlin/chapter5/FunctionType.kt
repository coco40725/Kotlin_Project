package chapter5
/*
1. Kotlin functions are first-class
which means they can be stored in variables and data structures,
and can be passed as arguments to and returned from other higher-order functions.
 **first-class 指的是 function 可以作為 variable 或 structure ， 並且也能作為 parameter 傳入 function

2. Function Type
These types have a special notation that corresponds to the signatures of the functions
- their parameters and return values.
function type 的寫法:
1. (variable type) -> variableType
(String) -> Int
2. [Class name].(variable type) -> variable type
String.(Int) -> String  代表這個 function 是寫在 String 裡面的，且 parameter 為 Int, return String

例如: 你可以定義這個 function 它會回傳一個 function
**/

/**
@author Yu-Jing
@create 2023/2/21 下午 12:23
 */

fun main() {
    val items = arrayListOf<Int>(1,2,3,4,5)
    // lambda function
    val joinedToString = items.fold("Elements:", { acc, i -> acc + " " + i })
    println(myFun(12, 44))
    println(myFun1(12, 44))

    //  anonymous function
    println(fun(a: Int, b: Int): Int {
        return a - b
    })

    // function reference
    val product =  items.fold(0, Int::times)

    // use function as return type
    val myReturn = returnFun()
    println(myReturn("123"))

    // Non-literal values of function types with and without a receiver are interchangeable
    println("你好".repeatFun(3))
    println(twoParameters("你好", 3))
    println(runTransformation(twoParameters))
    println(runTransformation(repeatFun))
}

fun <T, R> Collection<T>.fold(
    intial : R,
    combine : (acc : R, nextElement : T) -> R ) : R {
    var accumulator : R = intial
    for (element : T in this){
        accumulator = combine(accumulator, element)
    }
    return accumulator
}

/**
 * Use a code block within a function literal (function literal 又稱為 lambda expressions)
 * 使用  function literal 來撰寫 fun
 * */
val myFun = {a : Int, b : Int -> a + b}
// 等價於 ...
val myFun1 = fun (a : Int, b : Int) = a + b


/**
 * use function type as return
 * 定義一個 function, 其回傳的type 為 function
 * */
fun returnFun() : (String) -> Int {
    return fun(s:String) : Int = s.toInt()
}

/**
 * use function type as parameter
 * 定義一個 function, 其傳入的 parameter 為 function
 * */
fun parameterFun(myFun : (String) -> Int) : Int{
    return myFun("123")
}


/**
 * Non-literal values of function types with and without a receiver are interchangeable
 * */
val repeatFun : String.(Int) -> String = { times -> this.repeat(times)}
val twoParameters: (String, Int) -> String = repeatFun // (A,B) -> C 等價於 A.(B) -> C

fun runTransformation(f : (String, Int) -> String) : String = f("hello", 4)
