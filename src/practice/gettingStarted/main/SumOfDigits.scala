package practice.gettingStarted.main

/**
Write a function which takes a number as input & sums its digits to return a single digit.

SumOfDigits(123) = 6
//Explanation: 1+2+3=6

SumOfDigits(916) = 7
//Explanation: 9+1+6=16 => 1+6=7

SumOfDigits(19) = 1
//Explanation: 1+9=10 => 1+0=1

 SumOfDigits(8) = 8
//Explanation: 8 => 8

 */
object SumOfDigits extends App {

  def FindSumOfDigits(number: Int): Unit = {
    if(number < 10) number
    else FindSumOfDigits(number.toString.map(_.asDigit).toList.sum) // need to convert number => string and then back to digit
  }

  def AnotherFindSumOfDigits(number: Int, total: Int = 0): Int = {
    if(number == 0 && total <=9 ) total
    else if(number == 0 && total > 9) AnotherFindSumOfDigits(total, 0) // send new total as a new number for cases like 916 => 9 + 1 + 6 => 16 => 1 + 6 => 7
    else AnotherFindSumOfDigits(number/10, total+number%10)  // idea is to extract unit's place digit using % and keep adding till number tends to 0 then call else if
  }
  println(AnotherFindSumOfDigits(9))
  println(AnotherFindSumOfDigits(916))
  println(AnotherFindSumOfDigits(0))
}

// 916
// AnotherFindSumOfDigits(number/10, total+number%10)
// 916/10   , 0+916%10      => 91.6 , 0+6
// 91.6/10  , 0+6+91.6%10   => 9.16 , 0+6+1
// 9.16/10  , 0+6+91.6%10   => .916 , 0+6+1+9 => 0 , 16

// AnotherFindSumOfDigits(total, 0)
// 16,0
// AnotherFindSumOfDigits(number/10, total+number%10)
// 16/10  , 0+16%10     => 1.6 , 0+6
// 1.6/10 , 0+6+1.6%10  => .16 , 0+6+1 => 0,7
