package traits

trait Employee {
    String first
    String last
    abstract void work()

    String getName() { "$first $last" }
}