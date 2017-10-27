import java.util.ArrayList;

public class Orchestra {
	private String name;
	private ArrayList<String> musicians = new ArrayList<String>();
	private ArrayList<String> instruments = new ArrayList<String>();

	// Constructor
	public Orchestra(String name) {
		this.name = name;
	}

	// Question 5 part A 6 marks
	// Orchestra

	// Question 5 part B 4 marks
	public String getName() {
		if (name == null || name == "") {
			return "";
		} else
			return this.name;
	}

	public int getNumberOfMusicians() {
		if (musicians == null) {
			return 0;
		} else
			return musicians.size();
	}

	// Question 6 part A 4 marks
	public String toString() {
		String out = name + ":";
		out += musicians.toString();
		out += " ";
		out += instruments.toString();
		return out;
	}

	// Question 6 part B 4 marks
	public boolean hasMoreMusiciansThan(Orchestra other) {
		int otherSize;
		int thisSize;

		if (other == null || other.musicians == null)
			otherSize = 0;
		else {
			otherSize = other.musicians.size();
		}

		if (musicians == null) {
			thisSize = 0;
		} else {
			thisSize = musicians.size();
		}

		return thisSize > otherSize;
	}

	// Question 6 part C 4 marks
	public boolean join(String musicianName, String instrumentName) {
		if (musicianName.contains(musicianName)) {
			return false;
		} else {
			musicians.add(musicianName);
			instruments.add(instrumentName);
			return true;
		}
	}

	// Question 7 part A 5 marks
	public String shortestMusicianName() {
		int size = Integer.MAX_VALUE;

		String shortest = null;

		if (musicians == null || musicians.size() == 0) {
			return null;
		} else {
			for (String string : musicians) {
				if (string.length() < size) {
					shortest = string;
				}
			}
		}
		return shortest;

	}

	// Question 7 part B 5 marks
	public boolean hasMusicianInBoth(Orchestra other) {
		if (other == null || this == null || other.musicians == null
				|| this.musicians == null || other.musicians.size() == 0
				|| this.musicians.size() == 0) {
			return false;
		} else {
			for (String m1 : this.musicians) {
				for (String m2 : other.musicians) {
					if (m1.equals(m2)) {
						return true;
					}
				}
			}
			return false;
		}

	}

	// Question 8 8 marks
	public int numberOfDistinctInstruments() {

		ArrayList<String> temp = new ArrayList<String>();

		if (instruments == null || instruments.size() == 0) {
			return 0;
		} else {
			for (String a : instruments) {
				if (!temp.contains(a)) {
					temp.add(a);
				}
			}
			return temp.size();
		}
	}

}
