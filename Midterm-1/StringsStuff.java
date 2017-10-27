public class StringsStuff {
	public static void outputValue(int index, boolean answer) {
		if (answer)
			System.out.println(index + "  YES");
		else
			System.out.println(index + "  NO");
	}

	public static void main(String[] args) {
		java.util.Scanner in = new java.util.Scanner(System.in);
		String a = in.next(); // user types on the console red
		in.close();
		String b = "red";
		String c;
		c = b;
		String d = "Red";
		String e = "";
		String f = null;
		outputValue(0, a.equals(b));
		// 0 YES same characters in a and b

		outputValue(1, a == b);

		outputValue(2, b == c);

		outputValue(3, b.equals(f));

		b = "blue";
		outputValue(4, b == c);

		outputValue(5, e.equals(f));

		// outputValue(6, f.equals(e));

		outputValue(7, e.equals(e));

		outputValue(8, b.equals(d));

		outputValue(9, e == null);

		outputValue(10, null == f);

	}
} // end of class StringsStuff
