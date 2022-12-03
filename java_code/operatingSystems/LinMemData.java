package operatingSystems;
import java.io.BufferedOutputStream;	
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

// RUN THIS ONE FOR MEMORY COLLECTION
// uses the memory collector as a separately running thread to collect memory usage
// and append it to a string to be written to a text file
// so that a python program can parse the file and make a pretty graph with it
// because java makes everything SOOOOOO easy!
public class LinMemData {

	public static void main(String[] args) {
		
		int seed = 59617645;	// active seed for testing
		int size = 10000000;	// how many random numbers to generate each time
		int prng_r = 501;		// range of random numbers to generate is 0 to (prng_r-1)
		
		String lin_usages = "";
		
		File lin_usages_file = new File("TK_pi_lin_usages_java.txt");			// change filepaths according to system

		MemCollector collector = new MemCollector();
		collector.start();
		
		LinCon.lin_con(seed, size, prng_r);
		LagFib.lag_fib(seed, size, prng_r);
		MdlSqr.mdl_sqr(seed, size, prng_r);
		
		lin_usages = collector.getMem_usages();
		collector.stopRunning();
		collector.setMem_usages("");;
		
		try {
			collector.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// removes "null" from the beginning of the string
		lin_usages = lin_usages.substring(4);
		
		try(FileOutputStream fos = new FileOutputStream(lin_usages_file);
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {
			byte[] lin_bytes = lin_usages.getBytes();
			bos.write(lin_bytes);
			bos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
