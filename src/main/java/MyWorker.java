import java.util.concurrent.Callable;

public class MyWorker implements Callable<MyResult> {

	public MyResult call() throws Exception {
		System.out.println(Thread.currentThread().getName() + " (Start)");
		Thread.sleep(1000);
		System.out.println(Thread.currentThread().getName() + " (End)");

		// Illustrate threads which fails:
		if (Thread.currentThread().getName().contains("5"))
			return MyResult.FAILURE;
		return MyResult.SUCCESS;
	}

}
