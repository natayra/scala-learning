package com.rockthejvm

object PatternMatching extends App {

  // Switch expression
  val anInteger = 55
  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  }
  println(order) // 55th
  // PM (pattern matching) is an EXPRESSION

  // Case class decomposition
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 43) // equivalent to Person.apply("Bob", 43)

  val personGreeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case _ => "Something else"
  }
  println(personGreeting) // "Hi, my name is Bob and I am 43 years old"

  // deconstructing tuples
  val aTuple = ("Bon Jovi", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to the genre $genre"
    case _ => "I don't know what you are talking about"
  }
  println(bandDescription) // "Bon Jovi belongs to the genre Rock"

  // decomposing lists
  val aList = List(1,2,3)
  val listDescription = aList match {
    case List(_, 2, _) => "List containing 2 on its second position"
    case _ => "unknown list"
  }

  // if PM doesn't match anything, it will throw a MatchError - will crush your program
  // PM will try all cases in sequence
}
