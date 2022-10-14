package practice.gettingStarted.main

/*
  Write a function which takes a string as input and returns true if it contains all the numbers from 0 to 9.

  containsAllNumbers("a78b9c01cd3e4526fk") = true
  //Explanation: Has all the numbers 0 to 9

  containsAllNumbers("abcd1") = false
  //Explanation: Is not having all the numbers from 0 to 9

  containsAllNumbers("123456789") = false
  Explanation: 0 is missing
*/

object ZeroToNineIfExists extends App {
  def containsAllNumbers(aString: String): Boolean = {
    val regex = "[0-9]".r
    val numbers = regex.findAllIn(aString).toList
    numbers.distinct.length == 10
  }

  def AnotherContainsAllNumbers(aString: String) = {
    val numbers = aString.filter( x => {
      val num = x - '0' 
      num >=0 && num <= 9
    }).toList.distinct.mkString

    if (numbers.length() == 10) true else false
  }

  println(containsAllNumbers("a78b9c01cd3e4526fk"))
  println(containsAllNumbers("abcd1"))
  println(containsAllNumbers("123456789"))
}
