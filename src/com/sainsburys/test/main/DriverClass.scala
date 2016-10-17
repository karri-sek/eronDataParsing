package com.sainsburys.test.main

object DriverClass {
  
  def main(args: Array[String]){
    val awle = new AverageWorldLenghtOfEmails();
    awle.getAverageCount("InputFilesDirectoryLocation")
  }
  
}