package com.cpnv

import scala.annotation.targetName

trait Queue[A] {

  @targetName("isEmpty")
  def empty_? : Boolean;

  def enqueue(elem: A): Unit;

  def dequeue(): Unit;
}
