package bonusLessons

object TypeClasses {

  // Problem: Need of specialized implementations
  // ie. we define the processMyList which takes a list of any type of elements, processes it and returns an element of the same type
//  def processMyList[T](list: List[T]): T = {
    // let's say that we want to "sum up" all the elements of the List:
    // for integers => sum = actual SUM of the elements
    // for strings => sum = CONCATENATION of the elements
    // for other types => ERROR
//  }

  // Solution: Implicits
  trait Summable[T] {                                                         // trait + implicits = type class pattern
    def sumElements(list: List[T]): T
  }

  implicit object IntSummable extends Summable[Int] {
    override def sumElements(list: List[Int]) = list.sum
  }

  implicit object StringSummable extends Summable[String] {
    override def sumElements(list: List[String]) = list.mkString("")
  }

  def processMyList[T](list: List[T])(implicit summable: Summable[T]): T = {   // ad-hoc polymorphism
    summable.sumElements(list)
  }

  def main(args: Array[String]): Unit = {
    val intSum = processMyList(List(1, 2, 3))
    val stringSum = processMyList(List("Scala ", "is ", "awesome"))

    println(intSum)
    println(stringSum)

    // processMyList(List(true, false, true))  -> error at COMPILE time
  }

}
