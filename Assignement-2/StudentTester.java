//Tester for the student class, it creates 4 objects and test the class methods. 

public class StudentTester {

	public static void main(String[] args) {
		Student a = new Student("8667 Montcalm St", "Paulo Kinopk");
		Student b = new Student();
		Student c = new Student("6544 Grandville St", "    Tom    Le    ");
		Student d = new Student("123 mystreet st.", "    John       Rubick    ");

		tester(a, 3.5, 3, 3.33, 3, 4.0, 1, 3.6, 0, 1, 3, "Paulo Kinopk", "8667 Montcalm St", 7777, "pkin1", 2.749);
		tester(b, 1.5, 1, 3.33, 2, 3.0, -1, 6, 0, 1, 3, "unknown unknown", "unknown", 7778, "uunk2", 1.86);
		tester(c, 3, 2, 3.33, 1, 3.0, 0, 5, 3, 4, 3, "Tom    Le", "6544 Grandville St", 7779, "tle3", 3.55);
		tester(d, 12, 12, 23, 60, -10, -15, -15, 3, 4, 30, "John       Rubick", "123 mystreet st.", 7780, "jrub4", 4);

	}

	public static void tester(Student student, double grade1, int credits1, double grade2, int credits2, double grade3,
			int credits3, double grade4, int credits4, double grade5, int credits5, String name, String address,
			int studentNum, String login, double gpa) {
		// Adding a bunch of courses and calculating GPA
		student.addCourse(grade1, credits1);
		student.addCourse(grade2, credits2);
		student.addCourse(grade3, credits3);
		student.addCourse(grade4, credits4);
		student.addCourse(grade5, credits5);

		System.out.printf("Student Name: %s / Expected: %s\n", student.getName(), name);
		System.out.printf("Student Address: %s / Expected: %s\n", student.getAddress(), address);
		System.out.printf("Student Number: %d / Expected: %d\n", student.getStudentNum(), studentNum);
		System.out.printf("Student Login: %s / Expected: %s\n", student.getLoginId(), login);
		System.out.printf("Student GPA: %f / Expected: %f\n", student.getGPA(), gpa);
		System.out.println();
	}

}
