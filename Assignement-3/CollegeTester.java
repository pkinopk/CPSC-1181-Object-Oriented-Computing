import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Standard output user interface for the College class, which is a collection
 * of Students. There is an option for interaction via the console and also for
 * batch operations. The operations supported are
 * <ul>
 * <li>Adding a new student to the college.</li>
 * <li>Finding an existing student.</li>
 * <li>Retrieving the login id of an existing student.</li>
 * <li>Removing a student from the college.</li>
 * <li>Adding the grade point value and credit units earned for a course taken
 * by an existing student.</li>
 * <li>Finding a student with the college's highest GPA.</li>
 * <li>Giving the total number of students in the college.</li>
 * <li>Printing out to the console all the students in the college.</li>
 * <li>Putting a comment that is ignored i.e. has no effect.</li>
 * </ul>
 * 
 * @author Gladys Monagan modified by // HERE
 * @version September 23, 2017
 */

public class CollegeTester {
	/**
	 * Opens the input stream, processes command to process information on the
	 * students in the college and prints results to standard output.
	 * 
	 * @param args
	 *            line arguments -- ignored in this assignment
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean notInteractive = !isInteractiveModeFromUser(in);
		College college = new College();
		processCommands(college, in, notInteractive);
		in.close();
	}

	/**
	 * Prints a prompt to show that it's the system printing out.
	 * 
	 * @return the prompt used by the system for the user to read.
	 */
	public static String systemPrompt() {
		return "-> ";
	}

	/**
	 * Prints onto standard output a query to find out if the session is interactive
	 * and echoes the response if the session is not interactive. If the user using
	 * the Scanner <code>in</code> types any word starting with y or Y, we say that
	 * it IS interactive, otherwise, it is not.
	 * 
	 * @param in
	 *            an open input stream
	 * @return true if the session is interactive, false otherwise
	 */
	public static boolean isInteractiveModeFromUser(Scanner in) {
		System.out.print(systemPrompt() + "Is the session interactive? type \"yes\": ");
		String inputStr = in.nextLine();
		String answerStr = inputStr.trim().toLowerCase();
		boolean isInteractive = false;
		if (answerStr.length() >= 1) {
			answerStr = inputStr.substring(0, 1);
			isInteractive = answerStr.equalsIgnoreCase("y");
		}
		if (!isInteractive)
			echo(inputStr);
		return isInteractive;
	}

	/**
	 * Prints to standard output the string str to be used if the session is not
	 * interactive to show what the input was.
	 * 
	 * @param str
	 *            string to print to standard output
	 */
	public static void echo(String str) {
		System.out.println(str);
	}

	/**
	 * Prints as menu choices to standard output the commands available.
	 */
	public static void printAvailableCommands() {
		System.out.println("\n   Commands:");
		for (String str : Command.EXPLANATION) {
			System.out.println("\t" + str);
		}
	}

	/**
	 * Prints out a prompt to standard output and reads the next line. It continues
	 * reading as long as the line read is empty. If <code>notInteractive</code> is
	 * true, it outputs the line read by using the method <code>echo</code>
	 * (ignoring blank lines read).
	 * 
	 * @param in
	 *            an open input stream
	 * @param notInteractive
	 *            with a value of true indicates that the session is not interactive
	 *            and that the line read must be echoed
	 * @return the command in String form with "INVALID" as a possibility
	 */
	public static Command getNextCommand(Scanner in, boolean notInteractive) {
		System.out.print("-----------------------------------------------------");
		System.out.println("-----------------");
		System.out.print(systemPrompt() + "Enter a command: ");
		String str = in.nextLine().trim();
		while (str.length() == 0) {
			str = in.nextLine().trim();
		}
		if (notInteractive)
			echo(str);
		return Command.type(str);
	}

	/**
	 * Processes the commands that it gets using in and it asks the college to carry
	 * out various functions.
	 * <p>
	 * Precondition: the college is not null.
	 * </p>
	 * 
	 * @param college
	 *            the College that will have data manipulated
	 * @param in
	 *            an open input stream
	 * @param notInteractive
	 *            flag which when true, does not echo the input
	 */
	public static void processCommands(College college, Scanner in, boolean notInteractive) {
		Command cmd;
		do {
			if (!notInteractive)
				printAvailableCommands();

			cmd = getNextCommand(in, notInteractive);
			switch (cmd) {
			case ADD:
				add(college, in, notInteractive);
				break;
			case FIND:
				find(college, in, notInteractive);
				break;
			case LOGIN:
				getLogin(college, in, notInteractive);
				break;
			case REMOVE:
				remove(college, in, notInteractive);
				break;
			case COURSE:
				addCourse(college, in, notInteractive);
				break;
			case HIGHEST:
				findHighestGPA(college);
				break;
			case TOTAL:
				giveTotal(college);
				break;
			case PRINTALL:
				printOutCollege(college);
				break;
			case COMMENT:
				commentLines(in, notInteractive);
				break;
			case QUIT:
				// nothing to do
				break;
			default:
				printError("ignoring the invalid command");
				break;
			}
		} while (cmd != Command.QUIT);
	} // processCommands

	/**
	 * Creates a student and adds it to the college. It asks the user from stnadard
	 * input for a first and last name in a single line and subsequently it asks for
	 * an address (that is free formatted and may have blanks).
	 * <p>
	 * Precondition: the college is not null.
	 * </p>
	 * 
	 * @param college
	 *            the college of Students
	 * @param in
	 *            an open input stream
	 * @param notInteractive
	 *            declares that the session is not with the console but likely from
	 *            redirected input from a file
	 */
	public static void add(College college, Scanner in, boolean notInteractive) {
		System.out.print(systemPrompt() + "Enter the first name and last name: ");
		String name = in.nextLine();
		if (notInteractive)
			echo(name);
		if (!hasExactlyTwoWords(name)) {
			String errorMsg = "\"" + name + "\" should be a first name ";
			errorMsg += "followed by a last name on a single line";
			printError(errorMsg);
		} else {
			System.out.print(systemPrompt() + "Enter the address: ");
			String address = in.nextLine();
			if (notInteractive)
				echo(address);
			Student newbie = new Student(name, address);
			college.add(newbie);
			printStudent("added", newbie);
		}
	} // add

	/**
	 * Finds and prints to standard output the student given an student number which
	 * is obtained from standard input. If the student number given by the user is
	 * erroneous or if the student is not in the college, an error message is given
	 * onto standard output.
	 * <p>
	 * Precondition: the college is not null.
	 * </p>
	 * 
	 * @param college
	 *            the college of Students
	 * @param in
	 *            an open input stream
	 * @param notInteractive
	 *            declares that the session is not with the console but likely from
	 *            redirected input from a file
	 */
	public static void find(College college, Scanner in, boolean notInteractive) {

		int studentNum = getStudentNumberFromUser(in, notInteractive);
		Student student = college.find(studentNum);
		if (student == null) {
			printError("No match for this student number in our records");
		} else {
			printStudent("found", student);
		}

	} // find

	/**
	 * Obtains and prints to standard output the login id of a student whose student
	 * number is obtained from standard input. If the student number given by the
	 * user is erroneous or if the student is not in the college, an error message
	 * is printed onto standard output.
	 * <p>
	 * Precondition: the college is not null.
	 * </p>
	 * 
	 * @param college
	 *            the college of Students
	 * @param in
	 *            an open input stream
	 * @param notInteractive
	 *            declares that the session is not with the console but likely from
	 *            redirected input from a file
	 */
	public static void getLogin(College college, Scanner in, boolean notInteractive) {
		Student stud = getStudent(college, in, notInteractive);
		if (stud == null) {
			printStudent("login", stud);
		} else {
			System.out.println(systemPrompt() + "the login id is " + stud.getLoginId());
		}
	} // getLogin

	/**
	 * Deletes the student whose student number is obtained from standard input. The
	 * removed student is printed to standard output or an error message is printed
	 * if not found.
	 * <p>
	 * Precondition: the college is not null.
	 * </p>
	 * 
	 * @param college
	 *            the college of Students
	 * @param in
	 *            an open input stream
	 * @param notInteractive
	 *            declares that the session is not with the console but likely from
	 *            redirected input from a file
	 */
	public static void remove(College college, Scanner in, boolean notInteractive) {

		int studentNum = getStudentNumberFromUser(in, notInteractive);
		Student student = college.find(studentNum);
		if (student == null) {
			printError("No match for this student number in our records");
		} else {
			college.remove(studentNum);
			printStudent("removed", student);
		}
	} // remove

	/**
	 * Asks the user using standard input for the student number and if the student
	 * number is valid, it asks the user for the credits of a course (which should
	 * be numeric and positive) and if there are no errors, it asks for the points
	 * for the course (which should be numeric, positive and an integer). The
	 * credits and points are used to calculate the student's GPA. The errors are
	 * reported to standard output.
	 * <p>
	 * Precondition: the college is not null.
	 * </p>
	 * 
	 * @param college
	 *            the college of Students
	 * @param in
	 *            an open input stream
	 * @param notInteractive
	 *            declares that the session is not with the console but likely from
	 *            redirected input from a file
	 */
	public static void addCourse(College college, Scanner in, boolean notInteractive) {
		int studentNum = getStudentNumberFromUser(in, notInteractive);
		if (studentNum == -1) {
			// student does not exist
			return;
		}
		Student stud = college.find(studentNum);
		if (stud == null) {
			printStudent("no course", stud);
			return;
		}

		System.out.print(systemPrompt() + "Enter the grade points for a course: ");
		String inputStr = in.nextLine();
		if (notInteractive)
			echo(inputStr);
		Scanner numbersScanner = new Scanner(inputStr);
		// get the points or print an error message
		double points = getPointsFromUser(numbersScanner);
		numbersScanner.close();
		if (points >= 0) // i.e. no error was found
		{
			System.out.print(systemPrompt() + "Enter the credit units for the course: ");
			inputStr = in.nextLine();
			if (notInteractive)
				echo(inputStr);
			numbersScanner = new Scanner(inputStr);
			int credits = getCreditsFromUser(numbersScanner);
			numbersScanner.close();
			if (credits >= 0 && college.addCourse(points, credits, studentNum)) {
				printStudent("'s course was added", stud);
			} else {
				printError("Failed to add the course for student " + studentNum);
			}
		} // if (points >= 0)
	} // addCourse

	/**
	 * Prints one of the students with the college's highest GPA given that there
	 * might be more than one student with the highest GPA: only one is printed. If
	 * the college does not have any students yet, an error message is printed.
	 * <p>
	 * Precondition: the college is not null.
	 * </p>
	 * 
	 * @param college
	 *            the college of Students
	 */
	public static void findHighestGPA(College college) {

		Student student = college.getHighestGPA();
		printStudent("with the highest GPA", student);

	} // findHighestGPA

	/**
	 * Prints to standard output the total number of students in the college.
	 * <p>
	 * Precondition: the college is not null.
	 * </p>
	 * 
	 * @param college
	 *            the college of Students
	 */
	public static void giveTotal(College college) {

		System.out.println("Number of students: " + college.countStudent());

	} // giveTotal

	/**
	 * Outputs to standard output all the students of the college in a format
	 * enclosed in square brackets with one student per line.
	 * <p>
	 * Precondition: the college is not null and <code>toString</code> has been
	 * defined both for <code>Student</code> and for <code>College</code>.
	 * </p>
	 * 
	 * @param college
	 *            the college of Students
	 */
	public static void printOutCollege(College college) {

		System.out.println(college.printStudents());

	} // printOutCollege

	/**
	 * Reads a single line from standard input which t is considered a comment.
	 * <p>
	 * Precondition: the college is not null.
	 * </p>
	 * 
	 * @param in
	 *            an open input stream
	 * @param notInteractive
	 *            declares that the session is not with the console but likely from
	 *            redirected input from a file
	 */
	public static void commentLines(Scanner in, boolean notInteractive) {
		String commentLine = in.nextLine();
		if (notInteractive)
			echo(commentLine);
	} // commentLines

	/**
	 * Outputs onto standard output a string with a few stars before and after.
	 * 
	 * @param msg
	 *            the error message
	 */
	public static void printError(String msg) {
		System.out.println("->** " + msg + " **<-");
	}

	/**
	 * Outputs the student onto standard output; however, if stud is
	 * <code>null</code>, an error is printed.
	 * 
	 * @param what
	 *            gives what was done to the student, e.g. "added", "removed"
	 * @param stud
	 *            whose information will be printed.
	 */
	public static void printStudent(String what, Student stud) {
		if (stud == null) {
			// the stud is not in the college: print this out and return
			printError("No match for this student number in our records");
			return;
		}
		System.out.println(systemPrompt() + "A student " + what + ":");
		System.out.println("\t name: " + stud.getName());
		System.out.println("\t student number: " + stud.getStudentNum());
		System.out.println("\t address: " + stud.getAddress());
		System.out.println("\t login id: " + stud.getLoginId());
		System.out.println("\t GPA: " + String.format("%.1f", stud.getGPA()));
	}

	/**
	 * Obtains from standard input the student number and if it is valid, it returns
	 * the student from the college with that student number.
	 * <p>
	 * Precondition: the college is not null.
	 * </p>
	 * 
	 * @param college
	 *            the college of Students
	 * @param in
	 *            an open input stream
	 * @param notInteractive
	 *            declares that the session is not with the console but likely from
	 *            redirected input from a file
	 * @return the student with the student number read from the scanner in or null
	 *         if the student number is erroneous or no student with that student
	 *         number is found in the college.
	 */
	public static Student getStudent(College college, Scanner in, boolean notInteractive) {
		int studentNum = getStudentNumberFromUser(in, notInteractive);
		if (studentNum == -1) {
			return null;
		}
		return college.find(studentNum);
	}

	/**
	 * Asks the user using standard input to enter a student number. If the student
	 * number is not numeric, report the error.
	 * 
	 * @param in
	 *            an open input stream
	 * @param notInteractive
	 *            declares that the session is not with the console but likely from
	 *            redirected input from a file
	 * @return the student number if it is numeric and return -1 if an error was
	 *         encountered.
	 */
	public static int getStudentNumberFromUser(Scanner in, boolean notInteractive) {
		System.out.print(systemPrompt() + "Enter the student number: ");
		String num = in.nextLine();
		if (notInteractive)
			echo(num);
		int studentNum;
		if (isNumeric(num)) {
			studentNum = Integer.parseInt(num);
		} else {
			String errorMsg = "\"" + num + "\"";
			errorMsg += " is not a possible valid student number";
			printError(errorMsg);
			studentNum = -1;
		}
		return studentNum;
	}

	/**
	 * Asks the user using standard input for the points which should be numeric and
	 * positive: report errors to standard output
	 * 
	 * @param in
	 *            an open input stream
	 * @return the points obtained from the user or -1 if an error was encountered
	 */
	public static double getPointsFromUser(Scanner in) {
		boolean foundError = false;
		double points = 0; // to keep the compiler happy
		try {
			points = in.nextDouble();
		} catch (InputMismatchException e) // when the input is not a valid double
		{
			printError("The grade points should be numeric!");
			foundError = true;
		}
		if (!foundError && (points < 0)) {
			printError("The grade points cannot be negative ");
			foundError = true;
		}
		if (foundError)
			points = -1;
		return points;
	}

	/**
	 * Asks the user using standard input for the credits which should be numeric
	 * and positive (and an integer). Report errors to standard output.
	 * 
	 * @param in
	 *            an open input stream
	 * @return the credits obtained from the user or -1 if an error was encountered
	 */
	public static int getCreditsFromUser(Scanner in) {
		boolean foundError = false;
		int credits = 0; // to keep the compiler happy
		try {
			credits = in.nextInt();
		} catch (InputMismatchException e) // when the input is not a valid int
		{
			foundError = true;
		}
		if (!foundError && credits < 1) {
			foundError = true;
		}
		if (foundError) {
			printError("The credit units should be a positive integer!");
			credits = -1;
		}
		return credits;
	}

	/**
	 * Determines if str consists of exactly two words.
	 * <p>
	 * Precondition: str is not null.
	 * </p>
	 * 
	 * @param str
	 *            string to be examined for a blank inbetween
	 * @return true if str has exactly two words with at least one blank between the
	 *         words, false otherwise
	 */
	public static boolean hasExactlyTwoWords(String str) {
		String s = str.replaceAll("\\s{2,}", " ").trim();
		if (s.contains(" ") && s.indexOf(" ") == s.lastIndexOf(" ")) {
			return true;
		} else
			return false;
	}

	/**
	 * Determines if str consists of digits exclusively.
	 * <p>
	 * Precondition: str is not null.
	 * </p>
	 * 
	 * @return true if str consists of characters that are digits, false otherwise
	 * @param str
	 *            has characters that should be numeric but might not be
	 * @return true if every character of str is a digit or str is the empty string,
	 *         false otherwise (no concession is made for '+' or '-'
	 */
	public static boolean isNumeric(String str) {
		if (str == null) {
			return false;
		} else {
			try {
				int n = Integer.parseInt(str);
				if (n >= 0)
					return true;
				else
					return false;
			} catch (NumberFormatException e) {
				return false;
			}
		}
	}

}
