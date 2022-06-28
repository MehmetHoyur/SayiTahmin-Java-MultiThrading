package com.mehmet.SayiTahmin;

public class Main {
	public static void main(String[] args) {
		SayiTahmin sy=new SayiTahmin();
	
	Thread thr1=new Thread(new Runnable() {
		
		@Override
		public void run() {
			try {
				sy.Oyuncu1();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	});
	
	
	Thread thr2=new Thread(new Runnable() {
		
		@Override
		public void run() {
			try {
				sy.Oyuncu2();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	});
	
	thr1.start();
	thr2.start();
	
	
	try {
		thr1.join();
		thr2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	}
	
	
	

}
