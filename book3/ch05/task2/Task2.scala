import scala.beans.BeanProperty

class Student(
    @BeanProperty var name: String = "",
    @BeanProperty var id: Long = 0
) {
  override def toString(): String = {
    s"A student, id: ${id}, name: ${name}"
  }
}

object Task2 {
  def main(args: Array[String]): Unit = {
    println("-" * 30)
    println("Task2.\n")
    println("Creating a Student.")
    val student1: Student = new Student("example", -99)
    println("Printing initial student's data.")
    println(student1)
    println("Changing default student's data.")
    student1.setName("Tom")
    student1.setId(333)
    println("Printing changed student's data.")
    println(student1)
    println("\nThat's all. Goodbye!")
    println("-" * 30)
  }
}
