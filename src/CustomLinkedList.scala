package com.cpnv

class CustomLinkedList() {

  private var head: CustomNode = _
  private var tail: CustomNode = _
  private var size: Int = 0

  def addHead(value: Object): Unit = {
    val newNode = new CustomNode(value)
    if (head == null) {
      head = newNode
      tail = newNode
    } else {
      newNode.next = head
      newNode.previous = tail

      head = newNode
      head.previous = newNode
    }
    size += 1
  }

  def AddTail(value: Object): Unit = {
    val newNode = new CustomNode(value)
    if (tail == null) {
      head = newNode
      tail = newNode
    } else {
      newNode.next = head
      newNode.previous = tail
      newNode.previous.next = newNode
      tail = newNode
    }
    size += 1
  }

  def removeHead(): Unit = {
    if (head == null) {
      throw new NoSuchElementException
    } else {
      val value = head
      head = head.next
      size -= 1
    }
  }

  def removeTail(): Unit = {
    if (head == null) {
      throw new NoSuchElementException
    }
  }

  def getHead: Object = {
    // TODO
    null
  }

  def getTail: Object = {
    // TODO
    null
  }

  def getSize: Int = {
    // TODO
    0
  }

  def isEmpty: Boolean = {
    head == null
  }

  class CustomNode(data: Object) {
    var previous: CustomNode = _;
    var next: CustomNode = _;
  }
}
