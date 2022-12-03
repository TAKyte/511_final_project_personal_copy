package operatingSystems;
import java.util.ArrayList;
import java.util.List;

// middle square formula Seed -> seed^2 -> middle digit
// a length of 12 and 3:9 is needed for a long sequence couldn't find another working sequence.
public class MdlSqr extends Thread {

	public static List<Integer> mdl_sqr(int seed, int length, int prng_r) {
		// s is the seed
		int s = seed;
		// m is the range of values to generate
		int m = prng_r;
		// generated is array of randoms to return
		List<Integer> generated = new ArrayList<>();
		
		for (int i = 0; i <= length; i++) {
			// take the square value of the seed and make it a string
			String strS = Integer.toString(s*s);
			while (strS.length() < 12) {
				// if the size is smaller than 12 add 0 to both sides
				strS = '0' + strS + '0';
			}
			// set the new seed as the middle of the square
			s = Integer.valueOf(strS.substring(3, 9));
			// add the number to the list of randoms generated
			generated.add(s % m);
		}
		return generated;
	}
	
	// THREAD CODE
	private int seed;
	private int size;
	private int prng_r;
	
	public MdlSqr(int seed, int size, int prng_r) {
		this.seed = seed;
		this.size = size;
		this.prng_r = prng_r;
	}
	
	@Override
	public void run() {
		mdl_sqr(seed, size, prng_r);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
