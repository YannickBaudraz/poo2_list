package com.cpnv
package structure

trait Queue[A] {
  def size: Int

  def isEmpty: Boolean

  def enqueue(elem: A): Unit

  def dequeue(): Unit

  protected class EmptyQueueException extends RuntimeException {
    override def getMessage: String = "The queue is empty"
  }
}
