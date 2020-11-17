package com.rockthejvm

object Basics extends App {

  // defining a value
  val meaningOfLife: Int = 42 // val is like a const // meaningOfLife is the name of the const // Int is the type // 42 is the actual value

  // types can be Int, Boolean, Char, Double, Float, String
  val aBoolean = false // type is optional - the compiler figure it out

  // strings and strings operations
  val aString = "I love Scala"
  val aComposeString = "I" + " love" + " Scala"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  // expressions = structures that can be reduced to a value
  val anExpression = 2 + 3

  // if-expression
  val ifExpression = if (meaningOfLife > 43) 56 else 999 // example in Javascript - ternary operator: meaningOfLife > 43 ? 56 : 999
  val chainedIfExpression = {
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0
  }

  // code block
  val aCodeBlock = {
    // definitions
    val aLocalValue = 67

    // value of the block is the value of the last expression
    aLocalValue + 3
  }

  // define a function
  def myFunction(x: Int, y: String): String = {
    y + " " + x
  }

  // recursive function
  def factorial(n: Int): Int = {
    if(n <= 1) 1
    else n * factorial(n - 1)
  }

  /*
  factorial(5) = 5 * factorial(4) = 5 * 24 = 120
  factorial(4) = 4 * factorial(3) = 4 * 6 = 24
  factorial(3) = 3 * factorial(2) = 3 * 2
  factorial(2) = 2 * factorial(1) = 2 * 1
  factorial(1) = 1
  */

  // in Scala we don't use loops or iteration, we use RECURSION!

  // the Unit type = no meaningful value === "void" in other languages
  // is the type of SIDE EFFECTS
  println("I love Scala") // System.out.printls, printf, print, console.log, ...

  def myUnitReturningFunction(): Unit = {
    println("I don't love returning Unit")
  }

  val theUnit = ()
}