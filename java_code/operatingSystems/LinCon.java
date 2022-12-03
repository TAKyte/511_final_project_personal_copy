package operatingSystems;
import java.util.ArrayList;
import java.util.List;

// linear_congruential formula (a*s+c) mod M
public class LinCon extends Thread {

	public static List<Integer> lin_con(int seed, int length, int prng_r) {
		// a is a constant multiplier
		int a = 1526;
		// s is the seed
		int s = seed;
		// c value chosen to have no common factors with m to increase length of pattern
		int c = 57;
		// m is the range of values to generate
		int m = prng_r;
		
		// generated is an array holding the list of values to be returned
		List<Integer> generated = new ArrayList<>();
		
		// loop that generates a set number of randoms to be returned
		for (int i = 0; i <= length; i++) {
			int val = (a * s + c) % m;
			generated.add(val);
			s = val;
		}
		return generated;
	}
	
	// THREAD CODE
	private int seed;
	private int size;
	private int prng_r;
	
	public LinCon(int seed, int size, int prng_r) {
		this.seed = seed;
		this.size = size;
		this.prng_r = prng_r;
	}
	
	@Override
	public void run() {
		lin_con(seed, size, prng_r);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
