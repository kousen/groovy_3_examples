package misc

import groovy.transform.Canonical

import java.time.LocalDate

@Canonical
class User {
    String name

    // Elvis assignment
    String getName() { name ?= 'none' }
}

// ! used with instanceof and in
assert 42 !instanceof LocalDate
assert 4 !in [1, 3, 5, 7]

// Elvis assignment with null name
User u = new User()
assert u.name == 'none'

u = new User('Paul King')
u.name == 'Paul King'
assert u.name == 'Paul King'

// Reference equality vs equivalence
User u1 = new User('Paul King')
User u2 = new User('Paul King')
User u3 = u1

assert u1 == u2       // equivalence (equals method)
assert u3 === u1      // reference equality, delegates to 'is' method
assert !(u1 === u2)   // two separate objects
assert u1 !== u2      // same, alternate syntax
