package tree

import scala.collection.mutable.ArrayBuffer

/**
  * Created by apatters on 1/6/2018.
  */
class Node[T](var value: T) {

  var children: ArrayBuffer[Node[T]] = ArrayBuffer()

  private[tree] def addChild(child:Node[T]): Unit = {
    children += child
  }
}
