package operatingSystems;
import java.lang.Runtime;
import java.util.concurrent.TimeUnit;

// thread that collects memory data
public class MemCollector extends Thread {

	long mem_usage;
	String mem_usages;
	
	boolean running = true;
	
	Runtime runtime = Runtime.getRuntime();
	
	// Updates the mem_usage variables per tenth of a second
	@Override
	public void run() {
		while(running) {
			mem_usage = (runtime.totalMemory() - runtime.freeMemory()); // memory usage is in Bytes (Bytes to MiB: Bytes / 1024^2)
			mem_usages = mem_usages + Long.toString(mem_usage) + "\n";
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getMem_usages() {
		return mem_usages;
	}

	public void setMem_usages(String mem_usages) {
		this.mem_usages = mem_usages;
	}
	
	public void stopRunning() {
		this.running = false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
