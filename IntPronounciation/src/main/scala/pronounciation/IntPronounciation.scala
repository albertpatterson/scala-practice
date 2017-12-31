package pronounciation

import scala.math._


/**
  * creates the english pronunciation of an integer
  */
object IntPronounciation {

  def apply(value: Int): String ={
    pronounce(value)
  }

  /**
    * provide the english pronunciation of the provided integer
    *
    * @param value - the numeric value
    * @return - english pronounciation
    */
  def pronounce(value: Int): String = {


    if(value== 0) {
      "zero"
    }else{

      val sb = new StringBuilder()

      if(value<0){
        sb.append("negative ")
        sb.append(pronounce(math.abs(value).toInt))
      }else {

        // iteratively append partial pronounciations of the number (from highest magnitude to lowest)
        var remainder = value
        var mag: Int = 3 * ceil(log10(value) / 3).toInt
        while (mag >= 0) {

          // extract the relevant digits of partial pronounciation
          val irreleventPart: Int = remainder % Math.pow(10, mag).toInt
          val relevantPart: Int = remainder - irreleventPart
          val digits: Int = relevantPart / Math.pow(10, mag).toInt

          // append the partial pronounciation
          if (digits > 0) {
            val digWithMag = new DigsWithMag(digits.toInt, mag)
            val partialPronounciation = digWithMag.pronounce()
            if(sb.nonEmpty && !partialPronounciation.isEmpty){
              sb.append(" ")
            }
            sb.append(partialPronounciation)
          }

          // removed the relevant part from the remainder so that it is not pronounced again
          remainder -= relevantPart.toInt
          // decrease the magnitude for the next pronounciation
          mag -= 3
        }
      }

      sb.toString()
    }
  }
}
