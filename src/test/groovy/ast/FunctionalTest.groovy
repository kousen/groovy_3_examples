package ast

import spock.lang.Specification

class FunctionalTest extends Specification {
    def "fibonacci(#n) == #result"() {
        expect:
        Functional.fib(n) == result

        where:
        n || result
        0 || 1
        1 || 1
        2 || 2
        3 || 3
        4 || 5
        5 || 8
        6 || 13
        7 || 21
        8 || 34
        9 || 55
        100 || 1298777728820984005
    }

    def "factorial(#n) == #result"() {
        expect:
        result == Functional.fact(n)

        where:
        n || result
        0 || 1
        1 || 1
        2 || 2
        3 || 6
        4 || 24
        5 || 120
        10 || 3628800
        100 || 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
    }

    def "fact(70000) has 308,760 digits"() {
        when:
        def result = Functional.fact(70_000)

        then:
        "$result".size() == 308_760
    }
}
