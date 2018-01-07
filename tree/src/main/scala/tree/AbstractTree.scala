package tree

import scala.collection.mutable.{Queue, Set}

/**
  * Created by apatters on 1/7/2018.
  */
class AbstractTree[T](head: Node[T]) {

  protected var (duplicateFound, nodeSet) = findDuplicate(head)

  if(duplicateFound){
    throw new Error("Duplicate node found in tree")
  }
  // perform dfs, if find visited node, reject

  private def findDuplicate(node: Node[T]): (Boolean, Set[Node[T]]) = {
    var visited: Set[Node[T]] = Set()

    var duplicateFound = false

    def continue(): Boolean = {
      !duplicateFound
    }
    def operate(node: Node[T]): Unit = {
      duplicateFound = visited.contains(node)
      visited+=node
    }

    depthFirstSearch(node, continue, operate)

    (duplicateFound, visited)
  }

  def print(): Unit = {

    def continue() = true

    def operate(node:Node[T]): Unit = {

      println(node.value)
    }

    breadthFirstSearch(head, continue, operate)
  }

  // dfs
  protected def depthFirstSearch(node: Node[T], continue:()=>Boolean, operate: Node[T]=>Unit): Unit = {
    if(node!=null){
      operate(node)

      if(continue()){
        for(child <- node.children){
          depthFirstSearch(child, continue, operate)
        }
      }
    }
  }

  // bfs
  protected def breadthFirstSearch(node: Node[T], continue:()=>Boolean, operate: Node[T]=>Unit): Unit = {
    //  , visited: Set[Node[T]], queue: Queue[Node[T]]): Unit = {
      val queue: Queue[Node[T]] = Queue(node)

      while (continue() && queue.nonEmpty) {
        val curNode: Node[T] = queue.dequeue
        if(curNode!=null){
          operate(curNode)

          for (child <- curNode.children) {
            queue.enqueue(child)
          }
        }
      }
  }


  // in order traversal, perform some opp
}
