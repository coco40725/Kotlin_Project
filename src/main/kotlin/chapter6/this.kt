package chapter6
/*
In a member of a class: this refers to the current object of that class.

In an extension function or a function literal with receiver: this denotes the receiver parameter that is passed on the left-hand side of a dot.
* **/

/**
@author Yu-Jing
@create 2023-02-23-下午 03:11
 */

class A { // implicit label @A
    inner class B { // implicit label @B
        fun Int.foo() { // implicit label @foo
            val a = this@A // A's this
            val b = this@B // B's this

            val c = this // foo()'s receiver, an Int
            val c1 = this@foo // foo()'s receiver, an Int

            val funLit = lambda@ fun String.() {
                val d = this // funLit's receiver, a String
            }

            val funLit2 = { s: String ->
                val d1 = this // foo()'s receiver, an Int. Since funLit2 doesn't have any receiver
            }
        }
    }
}