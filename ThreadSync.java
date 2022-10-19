package college2;

class VirtualPrinter{
	
	void virtualPrint (int numOfCopies, String mssg) {
		for (int i=1; i<= numOfCopies; i++) {
			System.out.println("**Printing Copy: " + i + "\t for File: " + mssg);
		}
	}
}

class Thread1 extends Thread{
	VirtualPrinter pRef;
	
	Thread1(VirtualPrinter P){
		pRef = P;
	}
	
	@Override
	public void run() {
		pRef.virtualPrint( 10,  "Printing File 1");
	}
}

class Thread2 extends Thread{
	VirtualPrinter pRef;
	
	Thread2(VirtualPrinter P){
		pRef = P;
	}
	
	@Override
	public void run() {
		pRef.virtualPrint(10, "Printing File 2");
	}
}

public class ThreadSync {

	public static void main(String[]args) {
		System.out.println("--- Main Starting ---");
		
		VirtualPrinter ourPrinter = new VirtualPrinter();
		
		Thread1 t1ref = new Thread1(ourPrinter);
		t1ref.run();
		
		Thread2 t2ref = new Thread2(ourPrinter);
		t2ref.run();
		
		System.out.println("--- Main Ending ---");
	}
	
}
