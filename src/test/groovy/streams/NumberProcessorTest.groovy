package streams

import spock.lang.Specification

class NumberProcessorTest extends Specification {
    List nums = List.of(3, 1, 4, 1, 5, 9, 2, 6, 5)

    def "GroovySum"() {
        expect:
        36 == NumberProcessor.groovySum(nums)
    }

    def "GroovySumInject"() {
        expect:
        36 == NumberProcessor.groovySumInject(nums)
    }

    def "JavaStreams"() {
        expect:
        36 == NumberProcessor.javaStreams(nums)
    }

    def "JavaBinaryOperator"() {
        expect:
        36 == NumberProcessor.javaBinaryOperator(nums)
    }

    def 'filter nulls and only return evens'() {
        given:
        def nums = [3, null, 1, 4, null, 1, 5, null, 9]

        expect:
        NumberProcessor.nonNullEvens(nums) == [4]
    }
}
