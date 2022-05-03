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
        assert(list.isEmpty)
      }
    }

    "3, 2, 1 added to head" should {
      val list = new LinkedList[Int]
      list.addHead(3)
      list.addHead(2)
      list.addHead(1)

      "have size 3" in {
        assert(list.size == 3)
      }

      "have the head 1" in {
        assert(list.head == 1)
      }

      "have the tail 3" in {
        assert(list.tail == 3)
      }

      "have empty_? false" in {
        assert(!list.isEmpty)
      }
    }
  }
}
