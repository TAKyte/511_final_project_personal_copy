package operatingSystems;
import java.io.BufferedOutputStream;	
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ThreadMemData {

	public static void main(String[] args) {
		
		int seed = 59617645;	// active seed for testing
		int size = 10000000;	// how many random numbers to generate each time
		int prng_r = 501;		// range of random numbers to generate is 0 to (prng_r-1)
		
		String thread_usages = "";
		
		File thread_usages_file = new File("TK_pi_thread_usages_java.txt");	// change filepaths according to system

		MemCollector collector = new MemCollector();
		collector.start();
		
		LinCon t1 = new LinCon(seed, size, prng_r);
		t1.start();
		LagFib t2 = new LagFib(seed, size, prng_r);
		t2.start();
		MdlSqr t3 = new MdlSqr(seed, size, prng_r);
		t3.start();
		
		// join all threads
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread_usages = collector.getMem_usages();
		collector.stopRunning();
		collector.setMem_usages("");
		
		try {
			collector.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// removes "null" from the beginning of the string
		thread_usages = thread_usages.substring(4);
		
		try(FileOutputStream fos = new FileOutputStream(thread_usages_file);
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {
			byte[] thread_bytes = thread_usages.getBytes();
			bos.write(thread_bytes);
			bos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
