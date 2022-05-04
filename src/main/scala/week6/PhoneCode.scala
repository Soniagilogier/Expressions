package week6

import scala.io.Source

object PhoneCode extends App {

  /**
   *  Phone keys have mnemonics assigned to them.
   *  Assuming we are given a dictionary words as a list of words, we will design a method translate "translate(phoneNumber)"
   *  such that produces all phrases of words that an serve as mnemonics for the phone number
   */

  // Firstly, we get a dictionary from a file with a list of words
  val in = Source.fromURL("https://lamp.epfl.ch/wp-content/uploads/2019/01/linuxwords.txt")

  // we create a list with the words from the file dropping down the words containing chars different than letters
  val words = in.getLines().toList filter (word => word forall (chr => chr.isLetter))

  // Define the map of numbers to letters
  val mnemonics = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")

  // Invert the mnemonics Map to give a map from chars 'A' ... 'Z' to '2' ... '9'
  val charCode: Map[Char, Char] = for ((digit, str) <- mnemonics; ltr <- str) yield ltr -> digit

  // Map a word to the digit string it can represent, e.g. "Java" -> "5282"
  def wordCode(word: String): String = word.toUpperCase map charCode

  println(wordCode("Java")) // testing wordCode method
  println(wordCode("HelloWorld")) // testing wordCode method


  // Define a Map from digit strings to the words that represent them, e.g. "5282" -> List("Java", "Kata", "Lava", ...)
  // Note: a missing number should map to the empty set, e.g. "1111" -> List()
  val wordsForNum: Map[String, Seq[String]] = words groupBy wordCode withDefaultValue Seq()

  // Return all ways to encode a number as a list of words
  def encode(number: String): Set[List[String]] =
    if (number.isEmpty) Set(List())
    else {
      for {
        split <- 1 to number.length
        word <- wordsForNum(number take split)
        rest <- encode(number drop split)
      } yield word :: rest
    }.toSet

  println(encode("4355696753")) // testing encode method
  println(encode("7225247386"))

  // Translate the number to a whole phrase
  def translate(number: String): Set[String] = encode(number) map (_ mkString " ")

  println(translate("4355696753")) // testing translate method
  println(translate("7225247386"))
}
