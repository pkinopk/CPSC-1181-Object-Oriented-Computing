public class Surprise {
	// precondition: A is not null
	public static int f(int[] A, int x) {
		int m = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != x) {
				A[m] = A[i];
				m++;
			}
		}
		return m;
	}

	public static void printArray(int A[]) {
		System.out.print("{");
		for (int x : A) {
			System.out.print(x + " ");
		}
		System.out.println("}");
	}

	public static void printArray(int A[], int m) {

		System.out.print("{");
		for (int i = 0; i < m; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println("}");
	}

	public static void main(String[] args) {
		System.err.println("the original array");
		int[] A = { 1, 2, 4, 5, 2 };
		printArray(A);
		int x = 2;
		int m = f(A, x);
		System.err.println("after with x = " + x + " using m = " + m);
		printArray(A, m);
		printArray(A);

		System.err.println("\nthe original array");
		int[] B = { 1, 2, 2, 5, x };
		printArray(B);
		m = f(B, x);
		System.err.println("after with x = " + x + " using m = " + m);
		for (int i = 0; i < B.length; i++) {
			System.out.println(B[i]);
		}
		printArray(B);

		System.err.println("\nthe original array");
		int[] C = {};
		printArray(C);
		m = f(C, x);
		System.err.println("after with x = " + x + " using m = " + m);
		printArray(C, m);
		printArray(C);
	}
}
