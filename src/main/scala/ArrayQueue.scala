package com.cpnv

import java.util
import java.util.ArrayList
import scala.annotation.targetName

class ArrayQueue[A] extends Queue[A] {

  private val list: util.ArrayList[A] = new util.ArrayList[A]();

  @targetName("isEmpty")
  def empty_? : Boolean = list.isEmpty;

  def enqueue(elem: A): Unit = list.add(elem);

  def dequeue(): Unit = if (!this.empty_?) list.remove(0);
}
