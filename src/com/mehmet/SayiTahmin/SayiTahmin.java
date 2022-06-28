package com.mehmet.SayiTahmin;

import java.util.Iterator;
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
	int sayi=rnd.nextInt(5);
	
	
	
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
				bildimi=true;
				
			} else {
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
			bildimi=true;
			
		} else {
			lock.notify();
			lock.wait();
			

		}
		}
		
		
		
		}
		
		
		
	}

}
