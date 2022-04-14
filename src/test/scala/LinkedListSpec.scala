package com.cpnv

class LinkedListSpec extends UnitSpec {
  "A LinkedList" when {
    "empty" should {
      val list = new LinkedList

      "have size 0" in {
        assert(list.size == 0)
      }

      "throw an exception when we try to get the head" in {
        assertThrows[NoSuchElementException](list.head)
      }

      "throw an exception when we try to get the tail" in {
        assertThrows[NoSuchElementException](list.tail)
      }

      "have empty_? true" in {
        assert(list.empty_?)
      }
    }
  }
}
