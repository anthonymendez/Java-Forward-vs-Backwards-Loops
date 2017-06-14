import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Compute10MilRun {

	public static void main(String[] args) throws IOException {
		BufferedReader readF = new BufferedReader(new FileReader("ForwardRuns.txt")),
					   readB = new BufferedReader(new FileReader("BackwardRuns.txt"));
		
		PrintWriter write = new PrintWriter("Computed10MillionRun.txt","UTF-8");
		
		ArrayList<Long> forwardRuns = new ArrayList<Long>();
		ArrayList<Long> backwardRuns = new ArrayList<Long>();
		
		String currentLine; long currentNumber;
		
		System.out.println("Reading forward runs Data...");
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
		//Calculating Total Time, Time DifferenceAverage, and finding max and min
		long totaltimeF = 0, totaltimeB = 0, timedifference = 0, min = Long.MAX_VALUE, max = Long.MIN_VALUE; 
		double average = 0, stdev = 0; 
		
		for(int i = 0; i < forwardRuns.size(); i++){
			totaltimeF += forwardRuns.get(i);
			min = Math.min(min, forwardRuns.get(i));
			max = Math.max(max, forwardRuns.get(i));
		}
		average = ((double)totaltimeF)/((double)forwardRuns.size());
		stdev = STDEV(forwardRuns,average);
		System.out.println("Writing to file...");
		write.println(String.format("Total Time Forward: %d | Average: %f | Min: %d | Max: %d | Standard Dev: %f", totaltimeF, average, min, max, stdev));
		System.out.println("Calculating more stuff...");
		for(int i = 0; i < backwardRuns.size(); i++){
			totaltimeB += backwardRuns.get(i);
			min = Math.min(min, backwardRuns.get(i));
			max = Math.max(max, backwardRuns.get(i));
		}
		average = ((double)totaltimeB)/((double)backwardRuns.size());
		stdev = STDEV(backwardRuns,average);
		System.out.println("Writing to file...");
		write.println(String.format("Total Time Backward: %d | Average: %f | Min: %d | Max: %d | Standard Dev: %f", totaltimeB, average, min, max, stdev));
		
		timedifference = totaltimeF-totaltimeB;
		System.out.println("Writing to file...");
		write.println(String.format("Time Difference: %d",timedifference));
		System.out.println("DONE!");
		write.close();
		readF.close();
		readB.close();
	}
	
	static double STDEV(ArrayList<Long> values, double average){
		double stdev = 0;
		ArrayList<Double> temp = new ArrayList<Double>();
		for(long l : values){
			temp.add(l+0.0);
		}
		
		for(int i = 0; i < temp.size(); i++){
			temp.set(i, Math.pow(temp.get(i)-average,2));
		}
		
		double newsum = 0;
		for(double d : temp){
			newsum += d;
		}
		newsum /= temp.size();
		
		stdev = Math.sqrt(newsum);
		
		return stdev;
	}

}
