package com.cpnv

import java.util
import java.util.Objects
import java.util.function.Consumer
import scala.annotation.targetName
import scala.collection.mutable

class LinkedList[A] {

  private var _firstNode: Option[Node] = None
  private var _lastNode: Option[Node] = None
  private var _size: Int = 0

  /**
   * Get the first element of the list.
   */
  def head: A = _firstNode.get.value

  /**
   * Get the last element of the list.
   */
  def tail: A = _lastNode.get.value

  /**
   * Get the size of the list.
   */
  def size: Int = _size

  /**
   * Check if the list is empty.
   */
  def isEmpty: Boolean = _size == 0

  /**
   * Add an element at the beginning of the list.
   * @param value The value to add.
   */
  def addTail(value: A): Unit = {
    val node = new Node(value)
    if (isEmpty) _addOnEmptyList(node) else _addTail(node)
  }

  /**
   * Add an element at the end of the list.
   * @param value The value to add.
   */
  def addHead(value: A): Unit = {
    val node = new Node(value)
    if (isEmpty) _addOnEmptyList(node) 
    else _addHead(node)
  }

  /**
   * Remove the first element of the list.
   * @throws EmptyListException if the list is empty.
   */
  @throws[EmptyListException]
  def removeTail(): Unit = {
    if (isEmpty) throw new EmptyListException
    if (_size == 1) _removeHeadAndTail() else _removeTail()
  }

  /**
   * Remove the last element of the list.
   * @throws EmptyListException if the list is empty.
   */
  @throws[EmptyListException]
  def removeHead(): Unit = {
    if (isEmpty) throw new EmptyListException
    if (_size == 1) _removeHeadAndTail() else _removeHead()
  }

  /**
   * Iterate through all elements in the list.
   * @param f The consumer to apply to each element.
   */
  def forEach[U](f: A => U): Unit = {
    if (isEmpty) return

    var currentNode = _firstNode
    for (_ <- 0 until _size)
      f(currentNode.get.value)
      if (currentNode.get.hasNext) currentNode = currentNode.get.next
  }

  private def _addOnEmptyList(nodeToAdd: Node): Unit = {
    _firstNode = Some(nodeToAdd)
    _firstNode.get.next = Some(nodeToAdd)

    _lastNode = Some(nodeToAdd)
    _lastNode.get.previous = Some(nodeToAdd)

    _size += 1
  }

  private def _addTail(nodeToAdd: Node): Unit = {
    _lastNode.get.next = Some(nodeToAdd)
    nodeToAdd.previous = _lastNode
    if (_size == 1) _firstNode.get.previous = None

    _lastNode = Some(nodeToAdd)

    _size += 1
  }

  private def _addHead(nodeToAdd: Node): Unit = {
    _firstNode.get.previous = Some(nodeToAdd)
    nodeToAdd.next = _firstNode
    if (_size == 1) _lastNode.get.next = None
    _firstNode = Some(nodeToAdd)
    _size += 1
  }

  private def _removeHeadAndTail(): Unit = {
    _firstNode = None
    _lastNode = None
    _size = 0
  }

  private def _removeTail(): Unit = {
    _lastNode = _lastNode.get.previous
    _lastNode.get.next = None
    _size -= 1
  }

  private def _removeHead(): Unit = {
    _firstNode = _firstNode.get.next
    _firstNode.get.previous = None
    _size -= 1
  }


  private class Node(val value: A) {
    var previous: Option[Node] = None
    var next: Option[Node] = None

    def hasNext: Boolean = next.isDefined
  }

  private class EmptyListException extends RuntimeException {
    override def getMessage: String = "This LinkedList is empty."
  }
}
