package college2;

class VirtualPrinter { // Simulate a physical printer which is a shared resource

	// Function for printing
	void printOperation (int numOfCopies, String mssg) {
	
		for(int i=0; i<numOfCopies; i++) {
		
			System.out.println("**Printing Copy:" + i + "\t for file " + mssg);
		}
	}
}

class Thread1 extends Thread{
	
	VirtualPrinter pRef; // Reference to the virtual printer
	
	Thread1(VirtualPrinter p){ // Constructor << Define Some Initial Parameters -- pRef
		pRef = p;
	}
	
	@Override
	public void run() {
		pRef.printOperation(5, "From Thread 1");
	}
}
	
class Thread2 extends Thread{
	
	VirtualPrinter pRef; // Reference to the virtual printer
	
	Thread2(VirtualPrinter p){ // Constructor << Define Some Initial Parameters -- pRef
		pRef = p;
	}
	
	@Override
	public void run() {
		pRef.printOperation(5, "From Thread 2");
	}
}

public class labSubmissionConcurrency_24845 {
	
	public static void main(String[]args) {
		
		VirtualPrinter hp_printer = new VirtualPrinter();
		
		Thread1 printThread1 = new Thread1(hp_printer);
		Thread2 printThread2 = new Thread2(hp_printer);
		
		 
		
		// Synchronization
		printThread1.start();
		try {
			printThread1.join();
			}
		catch(InterruptedException e){
			System.out.println(e.toString());
		}
		
		printThread2.start();
		try {
			printThread2.join();
			}
		catch(InterruptedException e){
			System.out.println(e.toString());
		}
		
		hp_printer.printOperation(5, "Main Thread");
	}
}

// printThread1.run(); Run --> Program will start Main Thread and execute Run on the Main Thread
// Execute A Program throw --> System Generated Error try-catch statement