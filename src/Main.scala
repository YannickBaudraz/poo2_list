package com.cpnv

import com.cpnv.LinkedList

object Main {
  def main(args: Array[String]): Unit = {
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
    list.addHead(3)
    list.addHead(3)
    list.addHead(2)
    list.addHead(1)

    list.removeTail()
    list.removeTail()

    list.removeHead()
    list.removeHead()

    val head = list.head
    val tail = list.tail
    val sizeAtEnd = list.size
    val isEmptyAtEnd = list.empty_?

    println(s"At end: Head=$head;Tail=$tail;Size=$sizeAtEnd;Empty=$isEmptyAtEnd")
  }
}
