package chapter5
/*
1. 何謂 Tail Call: 當一個 function 被稱為 tail call function，指的是這個function 最後一步是
 呼叫其他function，例如:
 fun f(){
  ...do something...
  return g()
 }
 以下為 "非" Tail Call function:
 fun f(){
  ...do something...
  return g() + 1
 }

2. 為何 Tail call function 可以避免 stack overflow ?
假設你有三個 function: fun1, fun2, fun3，然後是 nested 的方式呼叫，也就是
fun1 呼叫 fun2， 而 fun2 呼叫 fun3。
一般情況下，你的 memory stack frame 的結構會是:
[fun3]
[fun2]
[fun1]
先出現的會先擺著，然後接著往上放，然後，處理 stack frame 則是由上往下處理，
然而這樣的設計，卻會因為過多的 function call 而導致 stack overflow，因此才會有 tail call。

如果是 tail call，則會由於 fun2 在 fun1 整個做完後才調用，則電腦會自動認為沒必要存取 fun1 的 stack frame，
以 func1 -> func2 -> func3 為例，
當 call func2 的動作在 func1 的對底部執行，那 func1 的 stack frame 就不需要了，
也叫表示記憶體可以釋出（因為 func1 做完了），以此類推：

[fun1] --> [fun2]   -->      [fun3]
           [fun1] remove     [fun2] remove
                             [fun1] remove
因此較不會有 stack 過度堆疊的問題

回到 kotlin 的 tailrec， 則如果你的 "遞迴 function" 是屬於 tail call，則
kotlin 會自動幫你優化它。

When a function is marked with the tailrec modifier and meets the required formal conditions,
the compiler optimizes out the recursion,
leaving behind a fast and efficient loop based version instead.
* */

/**
@author Yu-Jing
@create 2023/2/21 上午 11:30
 */

val eps = 1E-12

tailrec fun findFixPoint(x : Double = 1.0) : Double =
    if (Math.abs(x - Math.cos(x)) < eps) x else findFixPoint(Math.cos(x))
