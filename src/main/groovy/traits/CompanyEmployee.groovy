package traits

class CompanyEmployee implements Company, Employee {
    void work() { "Converting caffeine to code for money..." }

    String getName() {
        "${Employee.super.getName()} works for ${Company.super.getName()}"
    }
}
