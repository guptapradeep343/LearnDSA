package com.training.inv.stockledger;

import java.util.HashSet;
import java.util.Set;

public class ThreadTest {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		Thread t1 = new Thread(mt, "thread-1");
		Thread t2 = new Thread(mt, "thread-2");
		t1.start();
		t2.start();
	}
}

class MyThread implements Runnable {
	volatile int counter = 0;
	Set s = new HashSet();

	@Override
	public void run() {
		while (counter < 20) {
			synchronized (this) {
				if (s.add(counter++)) {
					System.out.println(Thread.currentThread().getName() + ":" + counter);
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
