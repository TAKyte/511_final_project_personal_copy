package operatingSystems;

public class ThreadData {
	
	public static String thread_data(int seed, int size, int prng_r) {
		// basic structure is as follows
		// get start time
		// result = method(active seed, size to generate, range of output)
	    // save time taken to generate 30m numbers with multi threading
	    // append that time to the time taken file
		
		float startTime = System.nanoTime();
		// call methods in their own threads
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
		
		// save time taken to generate numbers
		String time_process = Float.toString((System.nanoTime() - startTime)/1000000000);
		return time_process;
	}
	
	public static void main(String[] args) {
		// String test = thread_data(59617645, 10000000, 501);
		// System.out.println(test);
	}
}
