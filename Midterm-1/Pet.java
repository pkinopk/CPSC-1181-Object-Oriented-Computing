public class Pet {
	private String name;

	public void setName(String name) {
		if (this.name == null) {
			name = "Mr. " + name;
		} else {
			name = "Dr. " + this.name;
		}
		String Name = "Hon.  " + name;
		this.name = name;
	}

	public String getName() {
		return name;
	}
} // Pet
