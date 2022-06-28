package com.mehmet.SayiTahmin;

public class Main {
	public static void main(String[] args) {
		SayiTahmin sy=new SayiTahmin();
	
	Thread thr1=new Thread(new Runnable() {
		
		
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
	Thread thr3=new Thread(new Runnable() {
		
		@Override
		public void run() {
			sy.Zorluk();
			
		}
	});
	
	thr3.start();
	try {
		thr3.join();
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
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
