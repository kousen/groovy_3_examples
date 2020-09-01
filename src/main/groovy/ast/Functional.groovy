package ast

import groovy.transform.Memoized
import groovy.transform.TailRecursive

class Functional {
    @Memoized
    static long fib(long n) {
        if (n < 2) 1
        else fib(n - 1) + fib(n - 2)
    }

    @TailRecursive
    static def fact(n, acc = BigInteger.ONE) {
        n < 2 ? acc : fact(n - BigInteger.ONE, n * acc)
    }
}
