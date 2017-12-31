package pronounciation

/**
  * Created by apatters on 12/31/2017.
  */
object Main {
  def main(args: Array[String]) :Unit = {
    val myInt = -1927000023

    val pronounciation = IntPronounciation(myInt)
    println( myInt + " is pronounced \"" + pronounciation + "\"")  }
}
