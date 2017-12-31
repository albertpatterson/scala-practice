package pronounciation

/**
  * Created by apatters on 12/30/2017.
  */
class DigsWithMag(digs: Int, mag: Int) {

  /**
    * provide the pronounciation
 *
    * @return
    */
  def pronounce(): String = {
    val digPronounciation = pronounceDigs()
    val magPronounciation = pronounceMag()

    if(digPronounciation.isEmpty){
      ""
    }else{
      joinWithSpace(digPronounciation, magPronounciation)
    }
  }

  /**
    * pronounce the magnitude
 *
    * @return pronounciation of magnitude
    */
  def pronounceMag(): String ={
    mag match {
      case 0 => ""
      case 3 => "thousand"
      case 6 => "million"
      case 9 => "billion"
    }
  }

  /**
    * pronounce the digits
 *
    * @return pronounciation of the digits
    */
  def pronounceDigs(): String = {

    val tensValue = digs % 100
    val hundPronounciation = pronounceHundreds(((digs - tensValue)/100).toInt)
    val tenPronunciation = pronounceTens(tensValue)
    joinWithSpace(hundPronounciation, tenPronunciation)
  }

  /**
    * handle the general case ot pronouncing values < 100
 *
    * @param value the value to pronounce
    * @return pronounciation of the values
    */
  private def pronounceTens(value:Int): String = {
    value match {
      case 0 => ""
      case 1 => "one"
      case 2 => "two"
      case 3 => "three"
      case 4 => "four"
      case 5 => "five"
      case 6 => "six"
      case 7 => "seven"
      case 8 => "eight"
      case 9 => "nine"
      case 10 => "ten"
      case 11 => "eleven"
      case 12 => "twelve"
      case 13 => "thirteen"
      case 14 => "fourteen"
      case 15 => "fifteen"
      case 16 => "sixteen"
      case 17 => "seventeen"
      case 18 => "eighteen"
      case 19 => "nineteen"
      case 20 => "twenty"
      case 30 => "thirty"
      case 40 => "fourty"
      case 50 => "fifty"
      case 60 => "sixty"
      case 70 => "seventy"
      case 80 => "eighty"
      case 90 => "ninety"
      case _ => pronounceDefaultTen(value)
    }
  }

  /**
    * handle the typical case of pronouncing a value < 100
 *
    * @param value the value to pronounce
    * @return pronounciation of the values
    */
  private def pronounceDefaultTen(value:Int): String = {
    val tenFactor = (value/10).toInt
    pronounceTens(tenFactor*10) + " " + pronounceTens(value-tenFactor*10)
  }

  /**
    * handle the case of pronouncing a multiple of 100
 *
    * @param factor the multiple of 100
    * @return pronounciation of the values
    */
  private def pronounceHundreds(factor: Int): String = {
    if(factor==0){
      ""
    }else {
      pronounceTens(factor) + " hundred"
    }
  }

  /**
    * join two strings with a space
 *
    * @param s1 first string
    * @param s2 second string
    * @return join strings
    */
  private def joinWithSpace(s1: String, s2: String): String ={
    if(s1.isEmpty){
      s2
    }else if(s2.isEmpty){
      s1
    }else{
      s1 + " " + s2
    }
  }
}
