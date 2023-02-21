package chapter5

/**
@author Yu-Jing
@create 2023/2/21 上午 11:04
 */

fun main() {
    asList(1,3,4,"123")
    println()

    val aList = arrayOf(1,2,333)
    // [Ljava.lang.Integer;@2d98a335 22 你好， list的資料沒有打開
    asList(aList,22,"你好")
    println()

    //  If you already have an ARRAY (內容物必須是 reference type) and want to pass its contents to the function,
    //  use the spread operator (prefix the array with *):
    asList(*aList, 22, "你好") // 這裡就會把 array 的資料打開
    println()

    val intArray = intArrayOf(1,22,767)
    // asList(*intArray, "真的嗎") 這是錯誤的，因為intArray的內容物是存 primitive variable
    // 因此需要使用 * + toTypedArray()
    asList(*intArray.toTypedArray(),"吃炸雞")

}

fun <T> asList(vararg ts : T) : List<T> {
    val list = ArrayList<T>()
    for (t in ts){
        list.add(t)
        print("$t ")
    }
    return list
}

