package com.cpnv

import structure.{ArrayQueue, LinkedList, ListQueue, Queue}

import java.util
import scala.collection.immutable
import scala.collection.mutable.ListBuffer

@main
def main(): Unit = {
  ex1()
  ex2()
}

def ex1(): Unit = {
  val list = new LinkedList[Int]

  println(s"At start: Size=${list.size};Empty=${list.isEmpty}")

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

  println(s"At end: Head=${list.head};Tail=${list.tail};Size=${list.size};Empty=${list.isEmpty}")

  list.forEach(x => println(s"Value : $x"))
}

def ex2(): Unit = {
  ex2List()
  ex2Array()
}

def ex2List(): Unit = {
  println("\nListQueue")

  val smallListQueue: Queue[Int] = new ListQueue[Int]
  val largeListQueue: Queue[Int] = new ListQueue[Int]
  fillQueue(smallListQueue, 1000)
  fillQueue(largeListQueue, 100000)
  unfillQueue(smallListQueue)
  unfillQueue(largeListQueue)
}

def ex2Array(): Unit = {
  println("\nArrayQueue")

  val smallArrayQueue: Queue[Int] = new ArrayQueue[Int]
  val largeArrayQueue: Queue[Int] = new ArrayQueue[Int]
  fillQueue(smallArrayQueue, 1000)
  fillQueue(largeArrayQueue, 100000)
  unfillQueue(smallArrayQueue)
  unfillQueue(largeArrayQueue)
}

def fillQueue(queue: Queue[Int], count: Int): Unit = {
  val start: Long = System.currentTimeMillis()
  for (i <- 1 to count) queue.enqueue(i)
  val end: Long = System.currentTimeMillis()

  println(s"Time to fill queue: ${(end - start).toFloat / 1000}ms")
}

def unfillQueue(queue: Queue[Int]): Unit = {
  val start: Long = System.currentTimeMillis()
  for (_ <- 1 to queue.size) queue.dequeue()
  val end: Long = System.currentTimeMillis()

  println(s"Time to unfill queue: ${(end - start).toFloat / 1000}ms")
}
