package main;



public class Main {

	public static void main(String[] args) {
		
		SiteRunner dr = new SiteRunner();
		Thread tr = new Thread(dr); 
		tr.start();
		
		while (true) {
			
		}

	}

}
