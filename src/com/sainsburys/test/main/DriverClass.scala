package com.sainsburys.test.main

object DriverClass {
  
  def main(args: Array[String]){
    val awle = new AverageWordLenghtOfEmails();
    awle.getAverageCount("InputFilesDirectoryLocation")
  }
  
}