package college2;

class Task22 implements Runnable{ //Extends thread

	@Override
	public void run(){

		System.out.println("Entering print function in the class");

		for(int i=0; i<=10; i++) {
			System.out.println(">> From Task2 - Count=" + i);
		}
		System.out.println("Exiting print function in the class");
	}
}

class Task44 extends Thread{

	@Override
	public void run(){

		System.out.println("Entering print function in the class");

		for(int i=0; i<=10; i++) {
			System.out.println(">> From Task4 - Count=" + i);
		}
		System.out.println("Exiting print function in the class");
	}
}

class ThreadDemo2{

	public static void main(String[]args){

		//task 1
		System.out.println("** Starting Main **");

		//task 2
		//Task2 t2 = new Task2();


		//task 4
		//Task4 t4 = new Task4();

		Runnable t2 = new Task22();
		Runnable t4 = new Task44();
		
		Thread t2Thread = new Thread(t2);
		Thread t4Thread = new Thread(t4);
		
		t2Thread.start();
		t4Thread.start();

		//task 3
		System.out.println("** Endind Main **");
	}
}

