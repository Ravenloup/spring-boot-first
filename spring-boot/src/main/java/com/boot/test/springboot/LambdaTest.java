/**
 * 
 */
package com.boot.test.springboot;

/**
 * @author sunil.yadav
 *
 */
public class LambdaTest {

	public static void lambda() {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				System.out.println("Old way!");
			}
		});
		thread.start();
		
		Thread th = new Thread(() -> System.out.println("lambda way"));
		th.start();
	}
}
