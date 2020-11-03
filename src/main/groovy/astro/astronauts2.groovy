package astro

import groovy.sql.Sql

//@GrabConfig(systemClassLoader = true)
//@Grab('com.h2database:h2:1.4.200')

Sql sql = Sql.newInstance(url: 'jdbc:h2:~/astro', driver: 'org.h2.Driver')
sql.execute '''
  create table if not exists ASTRONAUTS(
    id int auto_increment primary key,
    name varchar(50),
    craft varchar(50)
  )
'''

response.people.each {
    sql.execute "insert into ASTRONAUTS(name, craft) values ($it.name, $it.craft)"
}

assert sql.rows('select * from ASTRONAUTS').size() == 6

sql.eachRow('select * from ASTRONAUTS') { row ->
    println "${row.name.padRight(20)} aboard ${row.craft}"
}

sql.close()
