Hi,
   ```AverageWordLenghtOfEmails``` program contains the logic for counting the average word length in the text files.
The mounted directory has so many txt files under the locations edrm-enron-v1 and edrm-enron-v2.
These txt files are contained in the ZIP files. For this assignment I prefer to work with XML files.

Class: DriverClass.scala contains the driver code to quick start the AverageWordLengthOfEmails program.

Assumption 1:
 1) The "input location" in the program assumes that all the txt files are located on this input location.
 
Approach:
  converting the contents in each txt files into RDD, for the convienence here I considered the content as String.
  Applied various transformations like map, filter and reduce. Finally converted the results to tuples and 
  calcuted the average.


