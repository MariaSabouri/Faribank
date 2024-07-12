package ir.ac.kntu.faribank.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerWrapper {
	private static ScannerWrapper instance = new ScannerWrapper();
	private Scanner scanner;
	
	public ScannerWrapper() {
		scanner = new Scanner(System.in);
	}
	
	public static ScannerWrapper getInstance() {
		return instance;
	}
	
	public String next() {
		String input = null;
		try {
			input = scanner.next();
		} catch (InputMismatchException e) {
			e.printStackTrace();
			scanner = new Scanner(System.in);
		}
		return input;
	}
	
	public Double nextDouble() {
		return scanner.nextDouble();
	}

	public Integer nextInt() {
		Integer input = 0;
		try {
			input = scanner.nextInt();
		} catch (InputMismatchException e) {
			scanner = new Scanner(System.in);
		}
		return input;
	}
	
	public void close() {
		scanner.close();
	}
}