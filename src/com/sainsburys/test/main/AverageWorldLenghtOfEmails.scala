package com.sainsburys.test.main

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

class AverageWorldLenghtOfEmails {
  
  /**
   * Checks whether the content is email is valid or not
   */
  def isValid(content: String): Boolean = {  
    return content.nonEmpty && content.length()>0
  }
  /**
   * This is an assumption actually the input files are hard to read where exactly the body content is
   */
  def getEmailBody(email: String): String = {
    //consider the lines after the subject line only
     val startIndex = email.indexOf("Subject")     
      email.substring(startIndex, email.length()-1);
  }
  /**
   * Counts the no of words in each email by splitting with word regex 
   * and converting those into tuples
   */
  
  def getWordCountAndNoOfFiles(content: String): (Int,Int)= {
                content.filter (x => isValid(x.toString()))
  	            .map { x => getEmailBody(x.toString()) }
  	            .map {x => x.split("\\W+").count { word => !word.isEmpty()}}
  	            .map {wordCount => (wordCount,1)} //Converting into tuple
  	            .reduce((t1,t2) => (t1._1+t2._1,t1._2+t2._2))
  }
  
  
  /*Assuming the input location contains the all the txt files to count on average word length 
   * File under text_000 folder example file names 3.856026.GYP3CJOAERDJRERMOVNV1OF3XWPYEBOLA.1.txt
   */
  def getAverageCount(inputLocation: String): Int = {
    
     val conf = new SparkConf().setAppName("context");
	   val fileAndFileContents = SparkContext.getOrCreate(conf).wholeTextFiles(inputLocation)
	   
	    val (_t1,_t2) = getWordCountAndNoOfFiles(fileAndFileContents.values.toString())
	    
	    _t1.toInt / _t2.toInt;
    
  }
  
  def calculateAvgLength(fileContents: String): Unit = {
    
  }
  
  
}