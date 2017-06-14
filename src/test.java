import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class test {

	public static void main(String[] args) throws SecurityException, IOException {
		//Length of the Array we're traversing through
		int arrayLength = 100000;
		int Array[] = new int[arrayLength];
		long currentTime, differenceInTime;
		//The amount of times the test will run
		int runLimit = 10000000;
		
		//Setting up the PrintWriter to write to our text files
		PrintWriter forwardWrite = new PrintWriter("ForwardRuns.txt","UTF-8"),
					backwardWrite = new PrintWriter("BackwardRuns.txt","UTF-8");
		
		//Setting up a Logger just in case. Don't use this to transfer to Excel. It will be a pain.
		Logger logger = Logger.getLogger("MyLog");
		FileHandler fileHandler = new FileHandler("LoopLog.log");
		logger.addHandler(fileHandler);
		SimpleFormatter simpleFormatter = new SimpleFormatter();
		fileHandler.setFormatter(simpleFormatter);
		logger.info(String.format("Loop Test | Runs: %d | Array Length: %d", runLimit, arrayLength));
		
		//Testing Loop
		for(int runCount = 0; runCount < runLimit; runCount++){
			//Take the current time.
			currentTime = System.nanoTime();
			//Go through array back to front
			for(int i = 0; i < arrayLength; i++){
				Array[i] = i;
			}
			//Find the time it took to go through the loop in nanoseconds.
			differenceInTime = System.nanoTime()-currentTime;
			//Write that to ForwardRuns.txt
			forwardWrite.println(differenceInTime);
			
			//Formally logging this to LoopLog.log
			String forward = String.format("Run: %d | Forward Loop Nano Time: %d", runCount+1,differenceInTime);
			logger.info(forward);
			
			//Take the current time.
			currentTime = System.nanoTime();
			//Go through array front to back.
			for(int i = arrayLength-1; i >= 0; i--){
				Array[i] = i;
			}
			//Find the time it took to go through the loop in nanoseconds.
			differenceInTime = System.nanoTime()-currentTime;
			//Write that to BackwardRuns.txt
			backwardWrite.println(differenceInTime);
			
			//Formally logging this to LoopLog.log
			String backward = String.format("Run: %d | Backwards Loop Nano Time: %d", runCount+1,differenceInTime);
			logger.info(backward);
		}
		
		//Log End of test and close PrintWriters
		logger.info("End of Test");
		forwardWrite.close();
		backwardWrite.close();
	}

}
