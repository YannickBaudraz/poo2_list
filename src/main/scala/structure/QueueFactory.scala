package com.cpnv
package structure

import scala.annotation.static

/**
 * @param param
 * @tparam A
 * @return
 */
def QueueFactory[A](param: String): Queue[A] = {
  val KIND_MAP = Map("memory" -> ArrayQueue[A], "speed" -> ListQueue[A])

  val ok = KIND_MAP(param)
  return ok;
}
