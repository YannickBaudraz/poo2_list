package com.cpnv
package structure

import structure.Queue

import java.util
import java.util.ArrayList
import scala.annotation.targetName
import scala.collection.mutable.ArrayBuffer

class ArrayQueue[A] extends Queue[A] {

  private val array = new ArrayBuffer[A]

  def size: Int = array.size

  def isEmpty: Boolean = array.isEmpty

  def enqueue(elem: A): Unit = array.addOne(elem)

  def dequeue(): Unit = if (isEmpty) throw new EmptyQueueException else array.remove(0)
}
