package syntax

// From release notes for Groovy 3.0
// http://groovy-lang.org/releasenotes/groovy-3.0.html

// do-while is now a thing
int count = 5
int fact = 1
do {
    fact *= count--
} while (count > 1)

assert fact == 120

// old-style Java for loop
def facts = []
def num = 5
for (int factorial = 1, i = 1; i <= num; i++, factorial *= i) {
    facts << factorial
}
assert facts == [1, 2, 6, 24, 120]

// multi-assignment in for loops
def combos = []
for (def (String s, int k) = ['a', 42]; k < 45; s++, k++) {
    combos << "$s $k"
}
assert combos == ['a 42', 'b 43', 'c 44']


