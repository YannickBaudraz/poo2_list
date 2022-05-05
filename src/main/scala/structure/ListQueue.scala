package com.cpnv
package structure

import scala.annotation.targetName

class ListQueue[A] extends Queue[A] {

  private val list = new LinkedList[A]()

  def size: Int = list.size

  def isEmpty: Boolean = list.isEmpty

  def enqueue(elem: A): Unit = list.addHead(elem)

  def dequeue(): Unit = if (isEmpty) throw new EmptyQueueException else list.removeHead()
}
