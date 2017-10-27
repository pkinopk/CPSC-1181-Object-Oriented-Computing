public class OrchestraTester {
	public static void main(String[] args) {
		Orchestra o = new Orchestra("Mama Mia");
		Orchestra other = new Orchestra("Other");
		System.out.println(o.getName());
		System.out.println(o.getNumberOfMusicians());
		System.out.println(o.toString());
		System.out.println(o.hasMoreMusiciansThan(other));
		System.out.println(o.shortestMusicianName());
		System.out.println(o.join("Paulo", "Piano"));
		System.out.println(o.toString());
	}

}
