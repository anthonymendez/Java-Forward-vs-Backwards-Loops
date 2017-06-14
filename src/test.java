import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class test {

	public static void main(String[] args) throws SecurityException, IOException {
		int length = 100000;
		int arr[] = new int[length];
		long currTime, diffTime;
		int runLimit = 10000000;
		
		PrintWriter forwardWrite = new PrintWriter("ForwardRuns.txt","UTF-8"),
					backwardWrite = new PrintWriter("BackwardRuns.txt","UTF-8");
		
		Logger log = Logger.getLogger("MyLog");
		FileHandler file = new FileHandler("LoopLog.log");
		log.addHandler(file);
		SimpleFormatter sm = new SimpleFormatter();
		file.setFormatter(sm);
		log.info(String.format("Loop Test | Runs: %d | Array Length: %d", runLimit, length));
		
		for(int run = 0; run < runLimit; run++){
			currTime = System.nanoTime();
			for(int i = 0; i < length; i++){
				arr[i] = i;
			}
			diffTime = System.nanoTime()-currTime;
			forwardWrite.println(diffTime);
			
			String forward = String.format("Run: %d | Forward Loop Nano Time: %d", run+1,diffTime);
			log.info(forward);
//			System.out.println(forward);
			
			currTime = System.nanoTime();
			for(int i = length-1; i >= 0; i--){
				arr[i] = i;
			}
			diffTime = System.nanoTime()-currTime;
			backwardWrite.println(diffTime);
			
			String backward = String.format("Run: %d | Backwards Loop Nano Time: %d", run+1,diffTime);
			log.info(backward);
//			System.out.println(backward);
		}
		log.info("End of Test");
		forwardWrite.close();
		backwardWrite.close();
	}

}
