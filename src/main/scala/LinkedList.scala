package com.cpnv

import java.util
import java.util.Objects
import java.util.function.Consumer
import scala.annotation.targetName

class LinkedList[A] {

  private val EMPTY_LIST_MESSAGE = "The LinkedList is empty."

  private var _head: Option[Node] = None
  private var _tail: Option[Node] = None
  private var _size: Int = 0

  /**
   * Get the first element of the list.
   */
  def head: A = _headNode.value

  /**
   * Get the last element of the list.
   */
  def tail: A = _tailNode.value

  /**
   * Get the size of the list.
   */
  def size: Int = _size

  /**
   * Add an element at the beginning of the list.
   */
  def addTail(value: A): Unit = {
    val nodeToAdd = new Node(value)
    if (empty_?) _addOnEmptyList(nodeToAdd) else _addTail(nodeToAdd)
  }

  /**
   * Check if the list is empty.
   */
  @targetName("isEmpty")
  def empty_? : Boolean = _size == 0

  private def _addOnEmptyList(nodeToAdd: Node): Unit = {
    _headNode = nodeToAdd
    _headNode.next = Some(nodeToAdd)

    _tailNode = nodeToAdd
    _tailNode.previous = Some(nodeToAdd)

    _size += 1
  }

  private def _headNode: Node = _head.getOrElse(throw new NoSuchElementException(EMPTY_LIST_MESSAGE))

  private def _headNode_=(node: Node): Unit = _head = Some(node)

  private def _tailNode: Node = _tail.getOrElse(throw new NoSuchElementException(EMPTY_LIST_MESSAGE))

  private def _tailNode_=(node: Node): Unit = _tail = Some(node)

  /**
   * Remove the first element of the list.
   */
  def removeTail(): Unit = {
    if (empty_?) throw new NoSuchElementException(EMPTY_LIST_MESSAGE)
    if (_size == 1) _removeHeadAndTail() else _removeTail()
  }

  /**
   * Remove the last element of the list.
   */
  def removeHead(): Unit = {
    if (empty_?) throw new NoSuchElementException(EMPTY_LIST_MESSAGE)
    if (_size == 1) _removeHeadAndTail() else _removeHead()
  }

  private def _addTail(nodeToAdd: Node): Unit = {
    _tail.get.next = Some(nodeToAdd)
    nodeToAdd.previous = Some(_tailNode)
    if (_size == 1) _headNode.previous = null

    _tailNode = nodeToAdd

    _size += 1
  }

  /**
   * Add an element at the end of the list.
   */
  def addHead(value: A): Unit = {
    val node = new Node(value)
    if (empty_?) _addOnEmptyList(node) else _addHead(node)
  }

  private def _addHead(nodeToAdd: Node): Unit = {
    _headNode.previous = Some(nodeToAdd)
    nodeToAdd.next = Some(_headNode)
    if (_size == 1) _tailNode.next = null

    _headNode = nodeToAdd

    _size += 1
  }

  /**
   * Iterate through all elements in the list.
   *
   * @param f The action to apply on each element.
   */
  def forEach[U](f: A => U): Unit = {
    if (empty_?) return
    var currentNode = _headNode
    while (currentNode != _tailNode)
      f(currentNode.value)
      currentNode = currentNode.next.get
  }

  private def _removeHeadAndTail(): Unit = {
    _headNode = null
    _tailNode = null

    _size = 0
  }

  private def _removeTail(): Unit = {
    _tailNode = _tailNode.previous.get
    _tailNode.next = null

    _size -= 1
  }

  private def _removeHead(): Unit = {
    _headNode = _headNode.next.get
    _headNode.previous = null

    _size -= 1
  }

  private class Node(val value: A) {

    var previous: Option[Node] = None
    var next: Option[Node] = None
  }
}
