package com.cpnv
package structure

import scala.annotation.static

/**
 * @param param The type of Queue wanted.
 * @tparam A The type of the elements in the Queue.
 * @return
 */
def QueueFactory[A](param: String): Queue[A] = {
  val KIND_MAP = Map(
    "memory" -> ArrayQueue[A],
    "speed" -> ListQueue[A]
  )

  KIND_MAP(param)
}
