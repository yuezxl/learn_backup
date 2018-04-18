package test.work;

import java.util.concurrent.CountDownLatch;

public class WorkerTestThread implements Runnable {
	private Worker worker;
	private CountDownLatch cdLatch;
	
	public WorkerTestThread(Worker worker, CountDownLatch cdLatch) {
		this.worker = worker;
		this.cdLatch = cdLatch;
	}

	@Override
	public void run() {
		worker.doWork();
		cdLatch.countDown();
	}

}
