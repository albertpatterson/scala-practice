import tree._

/**
  * Created by apatters on 1/6/2018.
  */
object Main {
  def main(args: Array[String]) = {
    println("testing")

    val node0 = new Node(0)
    var tree = new Tree[Int](node0)

    val node1 = new Node(1)
    tree.addNode(node1, node0)

    val node2 = new Node(2)
    tree.addNode(node2, node0)

    val node3 = new Node(3)
    tree.addNode(node3, node1)

    val node4 = new Node(4)
    tree.addNode(node4, node1)

    tree.print()

    println("Binary Search Tree")
    val node01 = new Node(0)
    var bst = new BinarySearchTree[Int](node01)

    val node11 = new Node(1)
    bst.addNode(node1)

    val noden11 = new Node(-1)
    bst.addNode(noden11)

    val noden31 = new Node(3)
    bst.addNode(noden31)

    bst.print()
  }
}
