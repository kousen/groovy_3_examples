package ast

import spock.lang.Specification

class NullDemoTestTest extends Specification {

    def "longerOf with non-null args"() {
        expect:
        assert NullDemo.longerOf('cat', 'canary') == 'canary'
    }

    def "longerOf with null string"() {
        when:
        NullDemo.longerOf('cat', null)

        then:
        IllegalArgumentException ex = thrown()
        ex.message == 'second cannot be null'

    }
}
