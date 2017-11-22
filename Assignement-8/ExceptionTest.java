import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {

		String s = "";
		Scanner in = new Scanner(s);

		try {
			test(in);
		} catch (Exception e) {
			System.out.println("String is not empty");
		}
	}

	public static void test(Scanner in) throws Exception {
		try {
			System.out.println(in.next());
			throw new Exception();
		} catch (NoSuchElementException e) {
			System.out.println("Inside test");
		}
	}
}
