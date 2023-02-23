package chapter5

import javax.swing.tree.TreeNode

/*
In Kotlin, you can only use a normal, unqualified return to exit a named function or an anonymous function.
To exit a lambda, use a "label".
A bare return is FORBIDDEN inside a lambda because a lambda cannot make the enclosing function return
    ** lambda function 不允許有 return ， 如果要跳脫 lambda function，請使用 label
But if the function the lambda is passed to is inlined, the return can be inlined, as well. So it is allowed.
    ** 但 inline function 則可以使用，值得注意的是 inline function 目前不支援 break continue，未來可能會加
**/

/**
@author Yu-Jing
@create 2023-02-23-上午 11:16
 */
fun main() {
    MyFun()
}


/**
 * closure
 */

fun MyFun(){
    var sum = 0
    fun innerFun(){
        sum += 2
        println(sum)
    }
    return innerFun()
}


/**
 * inline and non-inline function
 * */

inline fun <T> Collection<T>.each(block: (T) -> Unit) {
    for (e in this) block(e)
}
inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) {  }

/**
 * Non-local returns: return 是位在 lambda expression 裡面，而不是在  enclosing function
 * forEach 是 inline function
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

/**
 * Without Reified type parameters: 將 p 轉成 目標 class
 * call treeNode.findParentOfType(MyTreeNode::class.java)，但這樣很醜，
 * 因此 kotlin 提供了 Reified type parameters，讓我們可以"具象化" T
 * */
fun <T> TreeNode.findParentOfType(clazz: Class<T>): T? {
    var p = parent
    while (p != null && !clazz.isInstance(p)) {
        p = p.parent
    }
    @Suppress("UNCHECKED_CAST")
    return p as T?
}

// 使用 reified 時要使用 inline function
inline fun <reified T> TreeNode.findParentOfType(): T? {
    var p = parent
    while (p != null && p !is T) {
        p = p.parent
    }
    return p as T?
}

