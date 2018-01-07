package tree

/**
  * Created by apatters on 1/6/2018.
  */
class Tree[T](head: Node[T]) extends AbstractTree[T](head){

  def find(value: T) : Node[T] = {

    var matchingNode: Node[T] = null

    def continue() = matchingNode == null


    def operate(node:Node[T]): Unit = {
      if(node.value == value){
        matchingNode = node
      }
    }

    breadthFirstSearch(head, continue, operate)

    matchingNode
  }

  // add node, perform verify tree is still DAG via dfs
  def addNode(newNode: Node[T], parentNode: Node[T]): Unit = {
    if (!nodeSet.contains(parentNode)){
      throw new Error("Parent not contained in tree")
    }

    if (nodeSet.contains(newNode)){
      throw new Error("Duplicate node found in tree")
    }

    parentNode.addChild(newNode)
    nodeSet+=newNode
  }
}
