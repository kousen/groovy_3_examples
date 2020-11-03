package astro

import groovy.json.JsonSlurper

def json = new JsonSlurper().parse(
        "http://api.open-notify.org/astros.json".toURL())

println "There are ${json.number} people in space"
json.people.each {
    println "${it.name} aboard ${it.craft}"
}
