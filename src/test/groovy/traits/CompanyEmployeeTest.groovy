package traits

import spock.lang.Specification

class CompanyEmployeeTest extends Specification {

    def 'Peter Gibbons works for Initech'() {
        given:
        CompanyEmployee peter = new CompanyEmployee(first: 'Peter', last: 'Gibbons')

        expect:
        peter.name == 'Peter Gibbons works for Initech'
    }
}
