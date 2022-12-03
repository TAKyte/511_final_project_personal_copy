package operatingSystems;
import java.util.ArrayList;
import java.util.List;

// Lagged Fibonacci formula S(n-j)+S(n-k)%M,0<j<k
public class LagFib extends Thread {

	public static List<Integer> lag_fib(int seed, int length, int prng_r) {
		// s is the seed
		int s = seed;
		// j and k are ints in the seed
		int j = 2;
		int k = 4;
		// m is the range of values to generate
		int m = prng_r;
		
		// array of digits in seed
		List<Integer> digits = new ArrayList<>();
		String strS = Integer.toString(s);
		for (int x = 0; x < strS.length(); x++) {
			digits.add(Character.getNumericValue(strS.charAt(x)));
		}
		// array of random numbers to be returned
		List<Integer> generated = new ArrayList<>();
		
		// loop to generate a set amount of random numbers
		for (int i = 0; i <= length; i++) {
			int v1 = digits.get(j);
			int v2 = digits.get(k);
			int val = (v1 + v2) % m;
			generated.add(val);
			digits.remove(0);
			digits.add(val);
		}
		return generated;
	}
	
	// THREAD CODE
	private int seed;
	private int size;
	private int prng_r;
	
	public LagFib(int seed, int size, int prng_r) {
		this.seed = seed;
		this.size = size;
		this.prng_r = prng_r;
	}
	
	@Override
	public void run() {
		lag_fib(seed, size, prng_r);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
