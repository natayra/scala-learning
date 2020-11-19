package com.rockthejvm

object FunctionalProgramming extends App {

  // Scala is Object Oriented
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years!")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // INVOKING bob as a function === bob.apply(43)

  /*
    Scala runs on the JVM (Java Virtual Machine)
    Functional programming:
    - compose functions
    - pass functions as arguments
    - return functions as results

    Conclusion: FunctionX = Function1, Function2, ..., Function22 (22 is the max number of arguments that you can pass to a function)
   */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementer.apply(23) // 24
  simpleIncrementer(23) // same as simpleIncrementer.apply(23)
  // defined a function!

  // ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES

  // function with 2 arguments and a String return type
  val stringConcatenator = new ((String, String) => String) {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }
  stringConcatenator("I love", " Scala") // "I love Scala"

  // syntax sugar
  val doubler: Int => Int = (x: Int) => 2* x
  doubler(4) // 8

  /*
   equivalent to the much longer:

   val doubler: Function1[Int, Int] = new Function1[Int, Int] {
   override def apply(x: Int) = 2 * x
   }
  */

  // higher-order functions: take functions as args/return functions as results
  val aMappedList: List[Int] = List(1,2,3).map(x => x + 1) // HOF - higher-order function
  val aFlatMappedList = List(1,2,3).flatMap { x =>
    List(x, 2 * x)
  } // alternative syntax, same as .map(x => List(x, 2 * x)
  println(aFlatMappedList) // List(1, 2, 2, 4, 3, 6)
  val aFilteredList = List(1,2,3,4,5).filter(_ <= 3) // equivalent to x => x <= 3
  println(aFilteredList) // List(1, 2, 3)

  // all pairs between the numbers 1,2,3 and the letters 'a', 'b', 'c'
  val allPairs = List(1,2,3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter"))
  println(allPairs) // List(1-a, 1-b, 1-c, 2-a, 2-b, 2-c, 3-a, 3-b, 3-c)

  // for comprehensions
  val alternativePairs = for {
    number <- List(1,2,3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"
  // equivalent to the map/flatMap chain above

  /*
    * Collections
   */

  // lists
  val aList = List(1,2,3,4,5)
  val firstElement = aList.head
  val rest = aList.tail
  val aPrependedList = 0 :: aList // List(0,1,2,3,4,5)
  val anExtendedList = 0 +: aList :+ 6 // List(0,1,2,3,4,5,6)

  // sequences
  val aSequence: Seq[Int] = Seq(1,2,3) // Seq.apply(1,2,3)
  val accessedElement = aSequence.apply(1)
  println(accessedElement) // the element at index 1 is 2

  // vectors: fast Seq implementation
  val aVector = Vector(1,2,3,4,5)

  // sets = no duplicates
  val aSet = Set(1,2,3,4,1,2,3) // Set(1,2,3,4)
  val setHas5 = aSet.contains(5) // false
  val anAddedSet = aSet + 5 // Set(1,2,3,4,5) - not necessary in this order. Order is not important in a Set element
  val aRemovedSet = aSet - 3 // Set(1,2,4)

  // ranges
  val aRange = 1 to 1000
  val twoBytwo = aRange.map(x => 2 * x).toList // List(2,4,6,8,...,2000)

  // tuples = groups of values under the same value
  val aTuple = ("Bon Jovi", "Rock", 1982)

  // maps
  val aPhonebook: Map[String, Int] = Map(
    ("Daniel", 645323232),
    "Jane" -> 327285 // ("Jane", 327285)
  )


}


