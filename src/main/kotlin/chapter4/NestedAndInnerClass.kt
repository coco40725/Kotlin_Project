package chapter4
/*
In Java
Nested class: the "static" class which is declared in the class. doesn’t store a reference to an outer class
inner class: the "NON-STATIC" class which is declared in the class. stores a reference to an outer class

值得注意的是，在 kotlin 中，nested class 是不需要填寫 static

* */

/**
@author Yu-Jing
@create 2023-02-19-上午 08:51
 */
// In java， Taste 這個是 inner class
class Food{
    class Taste {

    }
}

// In Kotlin， Tshirt 這個是 nested class
class Clothes{
    class Tshirt{

    }
}

class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}