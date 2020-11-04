package astro

import com.google.gson.Gson
import groovy.sql.Sql

//@GrabConfig(systemClassLoader = true)
//@Grab('com.h2database:h2:1.4.200')

Sql sql = Sql.newInstance(url: 'jdbc:h2:~/astro', driver: 'org.h2.Driver')
sql.execute '''
    drop table if exists ASTRONAUTS;
    create table ASTRONAUTS(
        id int auto_increment primary key,
        name varchar(50),
        craft varchar(50)
    )
'''

static AstroResponse getAstroResponse() {
    new Gson().fromJson(
            'http://api.open-notify.org/astros.json'.toURL().text,
            AstroResponse)
}

AstroResponse response = astroResponse

response.people.each {
    sql.execute "insert into ASTRONAUTS(name, craft) values ($it.name, $it.craft)"
}

assert sql.rows('select * from ASTRONAUTS').size() == response.number

sql.eachRow('select * from ASTRONAUTS') { row ->
    println "${row.name.padRight(20)} aboard ${row.craft}"
}

sql.close()
