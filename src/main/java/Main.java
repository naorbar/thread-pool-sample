import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {

		System.out.println("STARTING ALL THREADS: " + new Date());

		ExecutorService executor = Executors.newFixedThreadPool(100);
		List<Future<MyResult>> futures = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			futures.add(executor.submit(new MyWorker()));
		}

		// Loop on the results:
		// Print the return value of Future, notice the output delay in console because
		// Future.get() waits for task to get completed
		System.out.println("ALL RESULTS:");
		for (Future<MyResult> future : futures) {
			try {
				System.out.println(future.get());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// shut down the executor service now
		executor.shutdown();
		System.out.println("SHUTDOWN ALL THREADS: " + new Date());
	}
}
