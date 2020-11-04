package astro

import com.google.gson.Gson
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

static AstroResponse getAstroResponse() {
    String jsonTxt = 'http://api.open-notify.org/astros.json'.toURL().text
    new Gson().fromJson(jsonTxt, AstroResponse)
}

AstroResponse response = astroResponse

println "There are ${response.number} people in space"
response.people.each {println it }