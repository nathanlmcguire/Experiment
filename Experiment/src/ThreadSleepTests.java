
public class ThreadSleepTests {

		public static void main(String[] args) {
			System.out.println("Bob started");
	         for (int i=1; i<=5; i++) {
	             try {
	                 //pausing the current thread for 'pause' seconds
	                 Thread.sleep(2000);
	               //print the counter after the pause
	                 System.out.println("Bob  - " + i); 
	            } catch (InterruptedException e) {
	                 System.out.println("Thread pause interrupted!");
	             }
	         }
	         System.out.println("Bob finished");
	     }
}
	 

