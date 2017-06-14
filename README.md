# Forwards vs Backwards Loops in Java
This was a quick test to see whether or not a forward or backwards loop is faster in Java. Inspired by this article: https://medium.com/@TravCav/why-reverse-loops-are-faster-a09d65473006

## Disclaimer

This was not a serious experiment by any means. I was bored and wanted to test out the differents between forward and backward loops in Java.

## My System

All of these runs were ran on a 2017 Dell Inspiron 15 Gaming 5000.
- Intel i5 7300HQ
- Nvidia GTX 1050 4GB
- DDR4 8GB Ram
- 5200RPM 1 TB Storage
So your mileage may vary for your system.

## Testing Methodology

I went through a total of 5 test runs. Each with a different amount of total run times. I first did 500 runs, then 10,000, then 1,000,000 runs, then 10,000,000 runs. Each times a run was completed, it would print out the results to a log file, and two different textfiles. The textfiles would be used to copy and paste all the data to an Excel Spreadsheet. 

However there were issues importing the 10,000,000 run data to Excel. When I copy and pasted the data from text files, Excel can only have a total of 1,048,576 entries. So to 

I set up the Excel Spreadsheet to calculate the Average Time, Standard Deviation, Lowest Time, Highest Time, Total Time, and Time Difference between the two runs.

My steps for each run were as follow:

1. Run the test and wait for it to finish.
2. Once finished, copy and paste all the from the text files to an Excel designated for this test run.
3. Eliminate any extreme outliers, otherwise, leave the data as is.
4. Start over at 1. but modify int runLimit.

## Results

### 500 Run Trial

| Data Type (ns) | Forward Runs | Backward Runs |
|---|---|---|
| Average Time | 40110.22435 | 39734.22721 |
| Standard Deviation | 20216.44531 | 19228.05157 |
| Lowest Time	| 32821	| 33641 |
|Highest Time |	7055584	| 6874661 |
|Total Time |	40110224352	| 39734227210 |
|Total Difference |	375997142	| -375997142 |


### 10,000 Run Trial



### 100,000 Run Trial



### 1,000,000 Run Trial



### 1,048,576 Run Trial



### 10,000,000 Run Trial (No Excel Visualization)

