package streams

import java.util.function.Predicate
import java.util.stream.Collectors

@SuppressWarnings('GroovyAssignabilityCheck')
class NumberProcessor {
    static int groovySum(List<Number> nums) {
        nums.findAll { it % 3 == 0 }
                .collect { it * 2 }
                .sum()
    }

    static int groovySumInject(List<Number> nums) {
        nums.findAll { it % 3 == 0 }
                .collect { it * 2 }
                .inject(0) { acc, n -> acc + n }
    }

    static int javaStreams(List<Number> nums) {
        nums.stream()
                .filter(n -> n % 3 == 0)
                .mapToInt(n -> n * 2)
                .sum()
    }

    static int javaBinaryOperator(List<Integer> nums) {
        nums.stream()
                .filter(n -> n % 3 == 0)
                .map(n -> n * 2)
                .reduce(0, Integer::sum)
    }

    static def nonNullEvens(List<Integer> nums) {
        Predicate<Integer> nonNull = Objects::nonNull
        Predicate<Integer> even = { it % 2 == 0 }

        nums.stream()
            .filter(nonNull & even)
            .toList()
    }
}

