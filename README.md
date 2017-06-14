# Forwards vs Backwards Loops in Java
This was a quick test to see whether or not a forward or backwards loop is faster in Java. Inspired by this article: https://medium.com/@TravCav/why-reverse-loops-are-faster-a09d65473006

## Disclaimer

This was not a serious experiment by any means. I was bored and wanted to test out the differents between forward and backward loops in Java.

## Testing Methodology

I went through a total of 4 test runs. Each with a different amount of total run times. I first did 500 runs, then 10,000, then 1,000,000 runs, then 10,000,000 runs. Each times a run was completed, it would print out the results to a log file, and two different textfiles. The textfiles would be used to copy and paste all the data to an Excel Spreadsheet. 

However there were issues importing the 10,000,000 run data to Excel. That a little bit later.

I set up the Excel Spreadsheet to calculate the Average Time, Standard Deviation, Lowest Time, Highest Time, Total Time, and Time Difference between the two runs.

## Results

### 500 Run Trial
