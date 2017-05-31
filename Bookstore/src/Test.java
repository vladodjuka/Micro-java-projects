
public class Test {
	public void test(){
		Book b1 = new Book("Knjiga 1", 40, 4);
		Book b2 = new Book("Knjiga 2", 20, 2);
		
		b1.addAuthor(1, "Autor 1");
		b1.addAuthor(4, "Autor 2");
		
		System.out.println("");
		System.out.println("Naziv knjige unazad: ");
		
		b1.showNameReverse();
		
		System.out.println("");
		
		
		System.out.println(b1.toString());

		System.out.println("");
		
		KidBook k1 = new KidBook("DjecijaKnjiga", 10, 1, 14);
		
		System.out.println(k1.toString());
		
		// Polimorfizam
		
		Book b4 = new KidBook("Djecija Knjiga 2", 4, 2, 1);
		
		ItBook i1 = new ItBook("It Knjiga", 20, 1, "Tematika", true); 
		
		System.out.println(b4.toString());
		
		System.out.println("");
		
		System.out.println("");
		
		BookStore ss = new BookStore("Knjizara 1", 4);
		try {
			ss.addBook(b1);
			ss.addBook(b4);
			ss.addBook(k1);
			ss.addBook(i1);
			//ss.addBook(b2);
		} catch (ExceptionAdd e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ss.showAll();
		
		
		System.out.println("");
		System.out.println("");
		
		//ss.deleteBooks(21);
		
		ss.showAll();
		
		System.out.println("");
		System.out.println("");
		
		ss.statistics();
		
		System.out.println("");
		System.out.println("");
		
		System.out.println("Podaci o slucajno odabranoj knjizi: ");
		ss.showRandom();
		
		
		System.out.println("");
		System.out.println("------\n Djecije knjige sa uzrastom do 14 godina: ");
		
		
		
		ss.showKids(14);
		
		System.out.println("");
		System.out.println("");
		
		ss.showIt();
		
		System.out.println("");
		System.out.println("");
		
		
		ss.averageNumberOfPages();
		
		
		
	}

}
