package com.cpnv

@main
def main(): Unit = {
  val list = new LinkedList

  val sizeAtStart = list.size
  val isEmptyAtStart = list.empty_?
  println(s"At start: Size=$sizeAtStart;Empty=$isEmptyAtStart")

  list.addTail(15)
  list.addTail(16)
  list.addTail(17)
  list.addTail(18)
  list.addTail(19)

  list.addHead(5)
  list.addHead(4)
  list.addHead(3)
  list.addHead(2)
  list.addHead(1)

  list.removeTail()
  list.removeTail()

  list.removeHead()
  list.removeHead()

  println(s"At end: Head=${list.head};Tail=${list.tail};Size=${list.size};Empty=${list.empty_?}")

  list.foreach(x => println(s"Value : $x"))
}