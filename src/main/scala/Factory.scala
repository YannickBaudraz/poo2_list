package com.cpnv

import structure.QueueFactory

object Factory {
  def main(args: Array[String]): Unit = {
    val queue1 = QueueFactory[Int](args(0))
    val queue2 = QueueFactory[Int](args(1))

    queue1.enqueue(42)
    queue2.enqueue(1337)

    println(s"queue1 is a ${queue1.getClass.getSimpleName}")
    println(s"queue2 is a ${queue2.getClass.getSimpleName}")
  }
}

