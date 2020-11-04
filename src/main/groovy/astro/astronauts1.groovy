package astro

import com.google.gson.Gson
import groovy.json.JsonSlurper
import groovy.transform.Canonical

// @Grab('com.google.code.gson:gson:2.8.6')

@Canonical
class Assignment {
    String name
    String craft
}

@Canonical
class AstroResponse {
    String message
    int number
    Assignment[] people
}

AstroResponse getAstroResponse() {
    String jsonTxt = 'http://api.open-notify.org/astros.json'.toURL().text
    def json = new JsonSlurper().parseText(jsonTxt)
    println "There are ${json.number} people in space"
    new Gson().fromJson(jsonTxt, AstroResponse)
}

getAstroResponse().people.each {println it }