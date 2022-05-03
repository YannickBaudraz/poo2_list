package com.cpnv

import scala.annotation.targetName

class ListQueue[A] extends Queue[A] {

  private val list: LinkedList[A] = new LinkedList[A]();

  @targetName("isEmpty")
  def empty_? : Boolean = list.empty_?

  def enqueue(elem: A): Unit = list.addHead(elem);

  def dequeue(): Unit = list.removeTail();
}
