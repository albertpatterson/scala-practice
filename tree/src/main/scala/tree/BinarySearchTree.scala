package tree

import scala.collection.mutable.ArrayBuffer

/**
  * Created by apatters on 1/6/2018.
  */
class BinarySearchTree[T <% Ordered[T]](head: Node[T]) extends AbstractTree[T](head){

    head.children=ArrayBuffer(null, null)

  // add node, perform verify tree is still DAG via dfs
  def addNode(newNode: Node[T]): Unit = {
    newNode.children=ArrayBuffer(null, null)
    addNode(newNode, head)
  }


  def find(value: T): Node[T] = {
    find(value, head)
  }

  private def find(value: T, node: Node[T]): Node[T] = {
    if(node.value==value){
      node
    }else if(node.value>value){
      if(node.children(0)!=null){
        find(value, node.children(0))
      }else{
        null
      }
    }else{
      if(node.children(1)!=null){
        find(value, node.children(1))
      }else{
        null
      }
    }
  }

  private def addNode(newNode: Node[T], refNode: Node[T]): Unit = {



    if(newNode.value <= refNode.value){
      if(refNode.children(0)==null){
        refNode.children(0)=newNode
      }else{
        addNode(newNode,refNode.children(0))
      }
    }else{
      if(refNode.children(1)==null){
        refNode.children(1)=newNode
      }else{
        addNode(newNode,refNode.children(1))
      }
    }
  }
}
