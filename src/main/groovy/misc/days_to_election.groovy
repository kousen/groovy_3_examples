package misc

import java.time.LocalDate
import java.time.Month
import java.time.Period

static String pluralize(long num) { num == 1 ? '' : 's' }

LocalDate electionDay = LocalDate.of(2020, Month.NOVEMBER, 3)
LocalDate today = LocalDate.now()
Period until = today.until(electionDay)

int years = until.years
int months = until.months
int days = until.days

println("There are ${electionDay - today} days until the election")
println "That's $years year${pluralize(years)}, " +
    "$months month${pluralize(months)}, and " +
    "$days day${pluralize(days)}"
