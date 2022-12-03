package operatingSystems;

public class LinData {
	
	public static String lin_data(int seed, int size, int prng_r) {
		// basic structure is as follows
		// get start time
		// result = method(active seed, size to generate, range of output)
	    // save time taken to generate 30m numbers without multi threading
	    // append that time to the time taken file
		
		float startTime = System.nanoTime();
		// call methods
		LinCon.lin_con(seed, size, prng_r);
		LagFib.lag_fib(seed, size, prng_r);
		MdlSqr.mdl_sqr(seed, size, prng_r);
		
		// save time taken to generate numbers
		String time_process = Float.toString((System.nanoTime() - startTime)/1000000000);
		return time_process;
	}
	
	public static void main(String[] args) {
		// String test = lin_data(59617645, 10000000, 501);
		// System.out.println(test);
	}
}
