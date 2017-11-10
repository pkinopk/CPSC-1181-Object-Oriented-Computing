public class Student2 {

	private static int studentsCount = 7777;
	public static final double MAX_GRADE = 4.33;
	private double sumOfCredits = 0;
	private double gradesTimesCredits = 0;

	private String name;
	private String address;
	private int studentNum;
	private String loginId;

	// Constructors
	public Student2() {
		this("unknown", "unknown unknown");
		studentsCount--;
	}

	public Student2(String studentName, String studentAddress) {
		name = studentName.trim();
		address = studentAddress;
		studentNum = generateStudentID();
		loginId = createLoginId(name, studentNum);
	}

	/**
	 * Returns a Student name
	 * 
	 * @return String Student name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns a Student address
	 * 
	 * @return String Student address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Returns a Student number
	 * 
	 * @return Integer Student number
	 */
	public int getStudentNum() {
		return studentNum;
	}

	/**
	 * Returns a Student loginId
	 * 
	 * @return Integer Student loginId
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * Returns a Integer Student number.
	 *
	 * @return Integer unique student number
	 */
	private static int generateStudentID() {
		return studentsCount++; // give a student a number and increment the students count
	}

	/**
	 * Returns the loginId based on the student's FirstName, LastName and StudentID
	 * 
	 * @param studentName
	 *            Student's name
	 * @param studentNum
	 *            Student's number
	 * @return String loginId
	 */

	/*
	 * Examples: “April Schauer” with a ‘studentNum’ 7777 has a ‘login id’ asch1
	 * “Norma Li” with ‘studentNum’ 10786 has ‘loginId’ nli4 “ Misty Waters” with
	 * ‘studentNum’ 9679 has ‘loginId’ mwat4 “Brock O” with ‘studentNum’ 8000 has
	 * ‘loginId’ bo8
	 */
	private static String createLoginId(String studentName, int studentNum) {

		String firstName = "";
		String lastName = "";
		String normalized = studentName.trim();
		if (normalized.contains(" ")) {
			firstName = normalized.substring(0, normalized.indexOf(" "));
			lastName = normalized.substring(normalized.lastIndexOf(" ") + 1, normalized.length());
		}

		int digitalRoot = getDigitalRoot(studentNum);
		if (firstName == "" || lastName == "") {
			return "";
		} else {
			if (lastName.length() >= 3) {
				return firstName.toLowerCase().charAt(0) + lastName.toLowerCase().substring(0, 3) + digitalRoot;
			} else if (lastName.length() == 2)
				return firstName.toLowerCase().charAt(0) + lastName.toLowerCase().substring(0, 2) + digitalRoot;
			else
				return firstName.toLowerCase().charAt(0) + lastName.toLowerCase().substring(0, 1) + digitalRoot;
		}
	}

	/**
	 * Returns the Digital Root of studentNum
	 * 
	 * @param studentNum
	 *            Number desired to get the digital root
	 * @return Integer digital root of studentNum
	 */
	private static int getDigitalRoot(int studentNum) {
		int sum = 0;
		while (studentNum >= 10) {
			sum += studentNum % 10;
			studentNum = studentNum / 10;
		}
		sum += studentNum;
		if (sum >= 10) {
			return getDigitalRoot(sum);
		}
		return sum;
	}

	/**
	 * Add a course to a student
	 * 
	 * @param grade
	 *            grade obtained on the course
	 * @param credits
	 *            number of credits the course if worth
	 */
	public boolean addCourse(double grade, int credit) {
		if (credit < 1 || grade < 0 || grade > MAX_GRADE) {
			return false; // Credit has to be an integer bigger or equal to 1 and grade has to be a double
			// between 0 and MAX_GRADE. Other values will be ignored.
		} else {
			sumOfCredits += credit;
			gradesTimesCredits += (grade * credit);
			return true;
		}
	}

	/**
	 * Calculates and updates student's GPA
	 */
	public double getGPA() {
		return gradesTimesCredits / sumOfCredits;
	}

}
