package com.mehmet.SayiTahmin;


import java.util.Random;
import java.util.Scanner;


public class SayiTahmin {
	
	String player1Name;
	String player2Name;
	Scanner scn=new Scanner(System.in);
	int tahmin;
	private Object lock=new Object();
	public boolean bildimi=false;
	
	Random rnd=new Random();
	int sayi;
	
	
	
	
	public synchronized void Zorluk() {
		Scanner nscn=new Scanner(System.in);
		System.err.println("Zorluk Seçiniz");
		System.out.println("Zorluk 1= 0,10 arası sayı \nZorluk 2= 0,25  arası sayı \nZorluk 3= 0,40 arası sayılar \nZorluk 4= 0,45 arasu sayılar \nZorluk 5= 0,50 arası sayılar");
		int zorluk=Integer.parseInt(nscn.nextLine());
		
		if (zorluk==1) {
			sayi=rnd.nextInt(10);
			
		}
		else if (zorluk==2) {
			sayi=rnd.nextInt(25);
		}
		else if (zorluk==3) {
			sayi=rnd.nextInt(40);
		}
		else if (zorluk==4) {
			sayi=rnd.nextInt(45);
		}
		else {
			sayi=rnd.nextInt(50);
		}
		if (zorluk>5||zorluk<1) {
			System.out.println("Belirtilen zorluk sevilerini seçiniz!!!!!!");
			Zorluk();
		}
		
		
	}
	
	public void Oyuncu1() throws InterruptedException {
		synchronized (lock) {
			
			
			System.out.println("Oyuncu 1 ismini giriniz");
			player1Name=scn.nextLine();
			lock.notify();
			lock.wait();
		while(!bildimi) {
			
			System.out.println(player1Name+" Tahminde Bulunuyor.....");
			tahmin=Integer.parseInt(scn.nextLine());
			if (tahmin==sayi) {
				System.out.println(player1Name+" KAZANDI!!!!!");
				System.out.println("Oynadığınız için teşekkürler");
				System.exit(1);
				bildimi=true;
				
			} 
			else if(tahmin>sayi) {
				System.out.println(player1Name+" Çok Büyük bir sayı girdiniz Tekrar deneyin...");
			}
			else {
				lock.notify();
				lock.wait();
				

			}
			
		}
		
			
			
			


		}
		
		
		
		
	}
	
	
	
	public void Oyuncu2() throws InterruptedException {
		synchronized (lock) {
			System.out.println("Oyuncu 2 ismini giriniz");
		player2Name=scn.nextLine();
		
		lock.notify();
		lock.wait();
		while(!bildimi) {
		System.out.println(player2Name+" Tahminde Bulunuyor.....");
		tahmin=Integer.parseInt(scn.nextLine());
		if (tahmin==sayi) {
			System.out.println(player2Name+" KAZANDI!!!!!");
			System.out.println("Oynadığınız için teşekkürler");
			System.exit(1);
			bildimi=true;
			
		} else {
			lock.notify();
			lock.wait();
			

		}
		}
		
		
		
		}
		
		
		
	}

}
