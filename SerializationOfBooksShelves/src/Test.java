
public class Test {
	public void test(){
		Book b = new Book("Knjiga 1", "Fjodor");
		Book b2 = new Book("Dostojevski", "Braca Karamazovi");
		
		Shelf shelf = new Shelf(2);
		
		shelf.add(b);
		shelf.add(b2);
		
		
		shelf.showAll();
		
		shelf.serialize("text.txt");
		
		System.out.println(Shelf.deserialize("text.txt"));
	}
}
