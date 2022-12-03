package operatingSystems;
import java.io.BufferedOutputStream;	
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		int seed = 59617645;	// active seed for testing
		int size = 10000000;	// how many random numbers to generate each time
		int prng_r = 501;		// range of random numbers to generate is 0 to (prng_r-1)
		int loop = 50;			// number of times to run PRNG
		String time_process;	// execution times to be written to files
		String lin_times = "";
		String thread_times = "";
		File lin_times_file = new File("C:/Users/omas1/OneDrive/Desktop/laptop_lin_times_java.txt");			// change filepaths according to system
		File thread_times_file = new File("C:/Users/omas1/OneDrive/Desktop/laptop_thread_times_java.txt");
		
		// generate times for a set number of runs of each method
		for(int x = 0; x < loop; x++) {
			System.out.println("Running loop: " + Integer.toString(x));
			// call non-threaded function get the time to generate 1000000 numbers in 3 different methods
			time_process = LinData.lin_data(seed, size, prng_r);
			lin_times = lin_times + time_process + "\n";
			
			// call threaded function get the time to generate 1000000 numbers in 3 different methods
			time_process = ThreadData.thread_data(seed, size, prng_r);
			thread_times = thread_times + time_process + "\n";
		}
		
		// Write linear times to output file
		try(FileOutputStream fos = new FileOutputStream(lin_times_file);
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {
			byte[] lin_bytes = lin_times.getBytes();
			bos.write(lin_bytes);
			bos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Write thread times to output file
		try(FileOutputStream fos = new FileOutputStream(thread_times_file);
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {
			byte[] thread_bytes = thread_times.getBytes();
			bos.write(thread_bytes);
			bos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
