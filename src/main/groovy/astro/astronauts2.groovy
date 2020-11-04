package astro

import com.google.gson.Gson
import groovy.json.JsonSlurper
import groovy.sql.Sql

//@GrabConfig(systemClassLoader = true)
//@Grab('com.h2database:h2:1.4.200')

Sql sql = Sql.newInstance(url: 'jdbc:h2:~/astro', driver: 'org.h2.Driver')
sql.execute '''
    drop table if exists ASTRONAUTS;
    create table if not exists ASTRONAUTS(
        id int auto_increment primary key,
        name varchar(50),
        craft varchar(50)
    )
'''

static AstroResponse getAstroResponse() {
    String jsonTxt = 'http://api.open-notify.org/astros.json'.toURL().text
    def json = new JsonSlurper().parseText(jsonTxt)
    new Gson().fromJson(jsonTxt, AstroResponse)
}

astroResponse.people.each {
    sql.execute "insert into ASTRONAUTS(name, craft) values ($it.name, $it.craft)"
}

assert sql.rows('select * from ASTRONAUTS').size() == astroResponse.number

sql.eachRow('select * from ASTRONAUTS') { row ->
    println "${row.name.padRight(20)} aboard ${row.craft}"
}

sql.close()
