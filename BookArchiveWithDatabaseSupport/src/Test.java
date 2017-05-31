
public class Test {

	public void test() {
		DatabaseConnection d = new DatabaseConnection("jdbc:mysql://localhost:3306/books", "root", "");
		// System.out.println(d.findTypeMaxId());
		// System.out.println(d.findBookMaxId());
		// d.insertType("Fantastika");
		// System.out.println(d.findTypeId("Fantastika"));
		// d.insertBook("Igra prestola", "Martin", "Fantastika");
		// d.insertBook("Romeo i Julija", "Sekspir", "Drama");
		System.out.println(d.allBooks());
		System.out.println("Drama: " + d.countByType("Drama"));
		System.out.println();
		System.out.println("Statistika:\n" + d.statsByType());
	}
}
