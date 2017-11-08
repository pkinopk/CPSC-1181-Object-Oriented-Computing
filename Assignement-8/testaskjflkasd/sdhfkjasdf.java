package testaskjflkasd;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class sdhfkjasdf {
	static String s = "junk";
	static Scanner in = new Scanner(s);

	public static void main(String[] args) {

		try {
			test();
		} catch (InputMismatchException e) {
			System.out.println("not empty");
		}
	}

	public static void test() throws InputMismatchException {
		try {
			in.next();
			throw new InputMismatchException();
		} catch (NoSuchElementException e) {
		}
	}
}
