package com.sda.utils;

import java.util.Scanner;

public final class MyScanner {
	
	static Scanner scanner;
	
	static {
		scanner = new Scanner(System.in);
	}	
	
		
	public static Scanner getScanner() {
		return scanner;
	}
			
	public static void closeScanner() {
		scanner.close();
	}

}
