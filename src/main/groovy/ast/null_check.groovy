package ast

import groovy.transform.NullCheck

// Adapted from user guide

class NullDemo {
    @NullCheck
    static String longerOf(String first, String second) {
        first.size() >= second.size() ? first : second
    }
}

