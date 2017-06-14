import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Compute10MilRun {

	public static void main(String[] args) throws IOException {
		//Create BF to read through each textfiles.
		BufferedReader readF = new BufferedReader(new FileReader("ForwardRuns.txt")),
					   readB = new BufferedReader(new FileReader("BackwardRuns.txt"));
		
		//Create PW to print out calculations
		PrintWriter write = new PrintWriter("Computed10MillionRun.txt","UTF-8");
		
		//ArrayList to contain all the values from the textfiles.
		ArrayList<Long> forwardRuns = new ArrayList<Long>();
		ArrayList<Long> backwardRuns = new ArrayList<Long>();
		
		System.out.println("Reading forward runs Data...");
		//Loop to go through each line of the textfile
		//We ignore 0 because it's impossible for a computer to go through
		//the data in 0 seconds.
		String currentLine; long currentNumber;
		while((currentLine = readF.readLine()) != null){
			currentNumber = Long.parseLong(currentLine);
			
			if(currentNumber == 0) continue;
			
			forwardRuns.add(currentNumber);
		}
		System.out.println("Reading backward runs Data...");
		while((currentLine = readB.readLine()) != null){
			currentNumber = Long.parseLong(currentLine);
			
			if(currentNumber == 0) continue;
			
			backwardRuns.add(currentNumber);
		}
		System.out.println("Calculating stuff...");
		//Calculating Total Time, Time DifferenceAverage, Standard Deviation and finding max and min
		long totaltimeF = 0, totaltimeB = 0, timedifference = 0, min = Long.MAX_VALUE, max = Long.MIN_VALUE; 
		double average = 0, stdev = 0; 
		//Loop through to calculate total time, and check if this current element is the lowest or highest value.
		for(int i = 0; i < forwardRuns.size(); i++){
			totaltimeF += forwardRuns.get(i);
			min = Math.min(min, forwardRuns.get(i));
			max = Math.max(max, forwardRuns.get(i));
		}
		//Calculate Average and Standard Deviation after we finished this loop.
		average = ((double)totaltimeF)/((double)forwardRuns.size());
		stdev = STDEV(forwardRuns,average);
		System.out.println("Writing to file...");
		
		//Write the information to Cmoputed10MillionRun.txt
		write.println(String.format("Total Time Forward: %d | Average: %f | Min: %d | Max: %d | Standard Dev: %f", totaltimeF, average, min, max, stdev));
		
		System.out.println("Calculating more stuff...");
		//Loop through to calculate total time, and check if this current element is the lowest or highest value.
		for(int i = 0; i < backwardRuns.size(); i++){
			totaltimeB += backwardRuns.get(i);
			min = Math.min(min, backwardRuns.get(i));
			max = Math.max(max, backwardRuns.get(i));
		}
		//Calculate Average and Standard Deviation after we finished this loop.
		average = ((double)totaltimeB)/((double)backwardRuns.size());
		stdev = STDEV(backwardRuns,average);
		System.out.println("Writing to file...");
		
		//Write the information to Cmoputed10MillionRun.txt
		write.println(String.format("Total Time Backward: %d | Average: %f | Min: %d | Max: %d | Standard Dev: %f", totaltimeB, average, min, max, stdev));
		
		//Calculate the difference in time between the two.
		timedifference = totaltimeF-totaltimeB;
		//Write that to the file.
		System.out.println("Writing to file...");
		write.println(String.format("Time Difference: %d",timedifference));
		System.out.println("DONE!");
		//Close PrintWriter and BufferedReaders.
		write.close();
		readF.close();
		readB.close();
	}
	static double STDEV(ArrayList<Long> values, double average){
		double stdev = 0;
		ArrayList<Double> temp = new ArrayList<Double>();
		//Go through each value in the list and place in our temporary list.
		for(long l : values){
			temp.add(l+0.0);
		}
		//Set the value of each index to be (indexvalue - average)^2
		for(int i = 0; i < temp.size(); i++){
			temp.set(i, Math.pow(temp.get(i)-average,2));
		}
		//Sum up the new values
		double newsum = 0;
		for(double d : temp){
			newsum += d;
		}
		//Divide by the size of the array
		newsum /= temp.size();
		//Square root and there we have Standard Deviation
		stdev = Math.sqrt(newsum);
		
		return stdev;
	}

}
