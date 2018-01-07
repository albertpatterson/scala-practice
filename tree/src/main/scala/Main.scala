import tree._

/**
  * Created by apatters on 1/6/2018.
  */
object Main {
  def main(args: Array[String]) = {

    println("Tree")

    val treeNode0 = new Node(0)
    var tree = new Tree[Int](treeNode0)

    val treeNode1 = new Node(1)
    tree.addNode(treeNode1, treeNode0)

    val treeNode2 = new Node(2)
    tree.addNode(treeNode2, treeNode0)

    val treeNode3 = new Node(3)
    tree.addNode(treeNode3, treeNode1)

    val treeNode4 = new Node(4)
    tree.addNode(treeNode4, treeNode1)

    tree.print()
    val treeNodeWithVal4 = tree.find(4)
    println("4 contained in Tree node: "+treeNodeWithVal4)
    val treeNodeWithVal5 = tree.find(5)
    println("5 contained in Tree node: "+treeNodeWithVal5)




    println("Binary Search Tree")
    val BSTNode0 = new Node(0)
    var bst = new BinarySearchTree[Int](BSTNode0)

    val BSTNode1 = new Node(1)
    bst.addNode(BSTNode1)

    val BSTNoden1 = new Node(-1)
    bst.addNode(BSTNoden1)

    val BSTNoden3 = new Node(3)
    bst.addNode(BSTNoden3)

    bst.print()

    val BSTNodeWithVal3 = bst.find(3)
    println("3 contained in BST Node: "+ BSTNodeWithVal3)
    val BSTNodeWithVal6 = bst.find(6)
    println("6 contained in BST Node: "+ BSTNodeWithVal6)
  }
}
