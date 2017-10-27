
import java.util.ArrayList;

public class College {

	ArrayList<Student> college = new ArrayList<Student>();

	/**
	 * Adds and student to college
	 * 
	 * @param student
	 *            an object of the class Student
	 * @return the object of the class Student added, or null if no student was
	 *         added.
	 */
	public Student add(Student student) {
		if (college.contains(student)) {
			return null;
		} else if (college.add(student)) {
			return student;
		} else
			return null;
	}

	/**
	 * Removes an student from college.
	 * 
	 * @param studentNum
	 *            an integer studentNum
	 * @return the object of the class Student removed from college, or null if no
	 *         student was removed
	 */
	public Student remove(int studentNum) {
		Student student = find(studentNum);
		if (student == null) {
			return null;
		} else {
			college.remove(student);
			return student;
		}
	}

	/**
	 * Finds a object Student using the studentNum
	 * 
	 * @param studentNum
	 *            an integer studentNum
	 * @return the object of the class Student matching studentNum, or null if
	 *         Student was not found
	 */
	public Student find(int studentNum) {
		for (Student student : college) {
			if (student.getStudentNum() == studentNum) {
				return student;
			}
		}
		return null;
	}

	/**
	 * Returns that loginId of a student
	 * 
	 * @param studentNum
	 *            an integer studentNum
	 * @return String loginId of the student, or null if Student was not found.
	 */
	public String getLoginId(int studentNum) {
		Student student = find(studentNum);
		if (student == null) {
			return null;
		} else {
			return student.getLoginId();
		}
	}

	/**
	 * Updates student records with a course history
	 * 
	 * @param studentNum
	 *            an integer studentNum
	 * @param grade
	 *            a double course grade
	 * @param credits
	 *            a integer credits awarded by course
	 * @return the object of the class Student matching studentNum, or null if
	 *         Student was not found
	 */
	public boolean addCourse(double grade, int credits, int studentNum) {
		Student student = find(studentNum);
		if (student == null) {
			return false;
		} else if (student.addCourse(grade, credits)) {
			return true;
		} else
			return false;
	}

	/**
	 * Returns the number of student in college
	 * 
	 * @param studentNum
	 *            an integer studentNum
	 * @return the number of students in college
	 */
	public int countStudent() {
		int count = college.size();
		return count;
	}

	/**
	 * Returns a representation of the students in college
	 * 
	 * @param studentNum
	 *            an integer studentNum
	 * @return a string representation of the students in the college
	 */
	public String printStudents() {
		String printOut = "";
		if (college.isEmpty()) {
			return null;
		} else {
			for (Student student : college) {
				printOut += "[Name: " + student.getName() + "] [ID: " + student.getLoginId() + "] [Student#: "
						+ student.getStudentNum() + "]\n";
			}
		}
		return printOut;
	}

	/**
	 * Returns the Student with the highest GPA
	 * 
	 * @return the object of the class Student with the highest GPA, or null if
	 *         Student college has no students
	 */
	public Student getHighestGPA() {
		Student bestStudent = new Student();
		double highestGPA = 0;
		if (college.size() == 0)
			return null;
		else {
			for (Student student : college) {
				if (student.getGPA() > highestGPA) {
					highestGPA = student.getGPA();
					bestStudent = student;
				}
			}
		}
		return bestStudent;
	}

}
