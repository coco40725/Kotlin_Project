package chapter4

/*
Kotlin has three structural jump expressions: (跟 java 一樣)
1. return : by default returns from the nearest enclosing function or anonymous function.
2. break: terminates the nearest enclosing loop.
3. continue: proceeds to the next step of the nearest enclosing loop.
* */

/**
@author Yu-Jing
@create 2023/2/21 上午 09:38
 */

fun main() {
    val forValue = forLoop()
    val whileValue = whileLoop()
    println(forValue)
    println(whileValue)

    forEachLoop1() // 1245
    println()
    forEachLoop2() // 12
    println()
    forEachLoop3() // 12 "this point is reachable!!"
}

/**
 * 使用 [loop名稱]@ for/while 來標示這個迴圈的名稱
 */
fun forLoop() : Int{
    var count = 0;
    myLoop@ for (i in 0..100){
        myLoop1@ for (j in 1..3){
            count += i + j
            if (count > 55) break@myLoop
        }
    }
    println("for loop is end")
    return count
}

fun whileLoop() : Int{
    var count = 0;
    myLoop@ while (count <= 55){
        myLoop1@ for (j in 1..3){
            count += j + 1
            if (count > 55) break@myLoop
        }
    }
    println("while loop is end")
    return count
}



/**
 * forEach
 * */
fun forEachLoop1() {
    listOf<Int>(1,2,3,4,5).forEach(fun (value : Int) {
        if (value == 3) return // local return forEach, which is similar to  continue
        print(value)
    })
    print(" this point is reachable!!")
}

fun forEachLoop2(){
    listOf<Int>(1,2,3,4,5).forEach{
        if (it == 3) return // non-local return the forEachLoop2 function， 因此最後一行的 println 不會碰到
        print(it)
    }
    print(" this point is unreachable")
}

fun forEachLoop3(){
    listOf<Int>(1,2,3,4,5).forEach myloop@{
        if (it == 3) return@myloop// local return myloop， which is similar to continue
        print(it)
    }
    print(" this point is reachable!!")
}