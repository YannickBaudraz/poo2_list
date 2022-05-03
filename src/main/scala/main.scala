package com.cpnv

import java.util

@main
def main(): Unit = {
  ex2();
}

def ex1(): Unit = {
  val list = new LinkedList[Int]

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

  list.forEach(x => println(s"Value : $x"))
}

def ex2(): Unit = {
  ex2List();
  ex2Array();
}

def ex2List(): Unit = {
  val smallListQueue = new ListQueue[Int]
  val largeListQueue = new ListQueue[Int];
  fillQueue(smallListQueue, 100);
  fillQueue(largeListQueue, 100000);
}

def ex2Array(): Unit = {
  val smallArrayQueue = new ArrayQueue[Int];
  val largeArrayQueue = new ArrayQueue[Int];
  fillQueue(smallArrayQueue, 100);
  fillQueue(largeArrayQueue, 100000);
}

def fillQueue(queue: Queue[Int], value: Int): Unit = {
  val start = System.currentTimeMillis();
  for (i <- 1 to value) queue.enqueue(i);
  val end = System.currentTimeMillis();

  println(s"Time to fill queue: ${end - start}");
}
