package chapter6



/**
@author Yu-Jing
@create 2023-02-23-下午 01:13
 */

fun main() {
    println(a?.length)
    println(b?.length)

    val list = listOf<String?>("Kotlin", null)
    // prints Kotlin and  null
    for (e in list){
        println(e)
    }
    // prints Kotlin and  IGNORE null
    for (e in list){
        e?.let {
            println(it)
        }
    }

    // safe cast
    val c = "123"
    val cInt : Int? = c as? Int
    println("cInt =  $cInt")
}

/**
 * Nullable types : variable type with "?"
 * non-null types : 一般 variable type 都是 non null type，因此不能有 null，一定程度上可以避免像是:
 *                  a.length 造成 NPE 的問題 (因為 a 一開始就不允許是 null ， 因此不會有以下的 NPE 問題)
 * */
var str : String = ""
// var str : String = null 會編譯錯誤
var strNull : String? = null

/**
 * Safe calls
 * */

val a = "Kotlin"
val b: String? = null
// a?.length
// b?.length


/**
 * Elvis operator:
 * If the expression to the left of ?: is not null,
 * the Elvis operator returns it, otherwise it returns the expression to the right.
 * Note that the expression on the right-hand side is evaluated only if the left-hand side is null.
 * */
val l : Int = if (b != null) b.length else -1
val elvis = b?.length ?: -1


/**
 * Safe casts: 如果轉不了，就變成 null
 * */
val c = "123"
val cInt : Int? = c as? Int