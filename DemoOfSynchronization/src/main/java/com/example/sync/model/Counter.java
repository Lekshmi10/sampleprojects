package com.example.sync.model;

public class Counter {
	 private int count=0;
	    
		public synchronized void decrement() {
		
			count--;
		}
		public synchronized void increment() {
			
			count++;
		}
		
		public synchronized int getValue() {
			
			return count;
		}
}

