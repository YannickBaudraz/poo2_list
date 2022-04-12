package com.cpnv

import scala.annotation.targetName

class LinkedList {

  private val EMPTY_LIST_MESSAGE = "The list is empty"
  private var _head: Node = _
  private var _tail: Node = _
  private var _size: Int = 0

  /**
   * Get the first element of the list.
   */
  def head: Any = _head.value

  /**
   * Get the last element of the list.
   */
  def tail: Any = _tail.value

  /**
   * Get the size of the list.
   */
  def size: Int = _size

  /**
   * Add an element at the beginning of the list.
   */
  def addTail(value: Any): Unit = {
    val nodeToAdd = new Node(value)
    if (empty_?) _addOnEmptyList(nodeToAdd) else _addTail(nodeToAdd)
  }

  private def _addTail(nodeToAdd: Node): Unit = {
    _tail.next = nodeToAdd
    nodeToAdd.previous = _tail
    if (_size == 1) _head.previous = null

    _tail = nodeToAdd

    _size += 1
  }

  private def _addOnEmptyList(nodeToAdd: Node): Unit = {
    _head = nodeToAdd
    _head.next = nodeToAdd

    _tail = nodeToAdd
    _tail.previous = nodeToAdd

    _size += 1
  }

  /**
   * Add an element at the end of the list.
   */
  def addHead(value: Any): Unit = {
    val node = new Node(value)
    if (empty_?) _addOnEmptyList(node) else _addHead(node)
  }

  private def _addHead(nodeToAdd: Node): Unit = {
    _head.previous = nodeToAdd
    nodeToAdd.next = _head
    if (_size == 1) _tail.next = null

    _head = nodeToAdd

    _size += 1
  }

  /**
   * Remove the first element of the list.
   */
  def removeTail(): Unit = {
    if (empty_?) throw new NoSuchElementException(EMPTY_LIST_MESSAGE)
    if (_size == 1) _removeHeadAndTail() else _removeTail()
  }

  private def _removeTail(): Unit = {
    _tail = _tail.previous
    _tail.next = null

    _size -= 1
  }

  /**
   * Remove the last element of the list.
   */
  def removeHead(): Unit = {
    if (empty_?) throw new NoSuchElementException(EMPTY_LIST_MESSAGE)
    if (_size == 1) _removeHeadAndTail() else _removeHead()
  }

  /**
   * Check if the list is empty.
   */
  @targetName("isEmpty")
  def empty_? : Boolean = _head == null && _tail == null && _size == 0

  private def _removeHeadAndTail(): Unit = {
    _head = null
    _tail = null

    _size = 0
  }

  private def _removeHead(): Unit = {
    _head = _head.next
    _head.previous = null

    _size -= 1
  }

  private class Node(val value: Any) {
    var previous: Node = _
    var next: Node = _
  }
}
