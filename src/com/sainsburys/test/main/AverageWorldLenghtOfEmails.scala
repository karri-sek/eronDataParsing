package com.sainsburys.test.main

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

class AverageWorldLenghtOfEmails {
  
  def isValid(content: String): Boolean = {
  
    return content.nonEmpty && content.length()>0
  }
  
  def getEmailBody(email: String): String = {
    //consider the lines after the subject line only
     val startIndex = email.indexOf("Subject")     
      email.substring(startIndex, email.length()-1);
  }
  
  
  /*Assuming the input location contains the all the txt files to count on average word length 
   * File unders text_000 folder example file names 3.856026.GYP3CJOAERDJRERMOVNV1OF3XWPYEBOLA.1.txt
   */
  def getAverageCount(inputLocation: String): Unit = {
    
     val conf = new SparkConf().setAppName("context");
	   val fileAndFileContents = SparkContext.getOrCreate(conf).wholeTextFiles(inputLocation)
	   //Map file Contents in to words and count of words
	   fileAndFileContents.mapValues { content =>  
	     content.filter (x => isValid(x.toString()))
	            .map { x => getEmailBody(x.toString()) }
	            .map {x => x.split("\\W+").count { word => !word.isEmpty()}}
	            .map {wordCount => (wordCount,1)} //Converting into tuple
	            
	   }
	   fileAndFileContents.filter(content => )
	   
     fileAndFileContents.mapValues { fileContent => 
           fileContent.redu { context => {
             1, context.split("\\W+").count { word => !word.isEmpty()) }
           }
             }
	   }.map(value => Tuple2(value,1))
	    .reduce((a,b) =>{
	      (a._1 + b._1) , (a._2 + b._2)
	    }
	       
  }
    
  }
  
  def calculateAvgLength(fileContents: String): Unit = {
    
  }
  
  
}