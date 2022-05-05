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
  val arrayQueue = new ArrayQueue[Int]
  val listQueue = new ListQueue[Int]

  val smallArrayQueue: Queue[Int] = arrayQueue
  val smallListQueue: Queue[Int] = listQueue

  val largeArrayQueue: Queue[Int] = arrayQueue
  val largeListQueue: Queue[Int] = listQueue

  fillQueue(smallArrayQueue, 100)
  fillQueue(smallListQueue, 100)

  fillQueue(largeArrayQueue, 100_000)
  fillQueue(largeListQueue, 100_000)

  val benchmarkCount = 200_000
  println(s"Benchmarking smallArrayQueue with $benchmarkCount elements")
  benchmark(smallArrayQueue, benchmarkCount)

  println(s"Benchmarking smallListQueue with $benchmarkCount elements")
  benchmark(smallListQueue, benchmarkCount)

  println(s"Benchmarking largeArrayQueue with $benchmarkCount elements")
  benchmark(largeArrayQueue, benchmarkCount)

  println(s"Benchmarking largeListQueue with $benchmarkCount elements")
  benchmark(largeListQueue, benchmarkCount)
}

def fillQueue(queue: Queue[Int], size: Int): Unit = for (i <- 1 to size) queue.enqueue(i)

def unfillQueue(queue: Queue[Int], size: Int): Unit = for (_ <- 1 to size) queue.dequeue()

def benchmark(queue: Queue[Int], count: Int): Unit = {
  benchmarkEnqueue(queue, count)
  benchmarkDequeue(queue, count)
}

def benchmarkEnqueue(queue: Queue[Int], count: Int): Unit = {
  val start: Long = System.currentTimeMillis()
  fillQueue(queue, count)
  val end: Long = System.currentTimeMillis()

  println(s"Time to fill queue: ${(end - start).toFloat / 1000}ms")
}

def benchmarkDequeue(queue: Queue[Int], count: Int): Unit = {
  val start: Long = System.currentTimeMillis()
  unfillQueue(queue, count)
  val end: Long = System.currentTimeMillis()

  println(s"Time to unfill queue: ${(end - start).toFloat / 1000}ms")
  println()
}
