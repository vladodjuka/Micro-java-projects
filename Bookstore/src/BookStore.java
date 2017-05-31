import java.util.Random;

public class BookStore implements Inter{
	private String name;
	private int maxBooks;
	private Book[] books;
	
	
	public BookStore(String name, int maxBooks) {
		super();
		this.name = name;
		this.maxBooks = maxBooks;
		this.books = new Book[maxBooks];
	}
	
	public void showAll(){
		System.out.println("Knjizara "+name+", maksimalan broj knjiga: "+maxBooks+"\nKnjige:\n");
		for (int i = 0; i < books.length; i++) {
			if(books[i]!=null){
				System.out.println(books[i].toString());
			}
			else{
				System.out.println("- prazna pozicija");
			}
		}
	}
	
	public void addBook(Book b1) throws ExceptionAdd{
		for (int i = 0; i < books.length; i++) {
			if(books[i]!=null){
			if(books[i].getName().equals(b1.getName())){
				throw new ExceptionAdd("Ta knjiga vec postoji u knjizari.");
			}
			}
			if(books[i]==null){
				books[i]=b1;
				return;
			}
		}
		throw new ExceptionAdd("Nema mjesta u nizu.");
		
	}
	
	public void deleteBooks(int noOfPages){
		for (int i = 0; i < books.length; i++) {
			if(books[i]!=null){
				if(books[i].getNoOfPages()<noOfPages){
					books[i]=null;
				}
			}
		}
	}
	
	public void statistics(){
		int all = 0;
		int kid=0;
		int it = 0;
		int other=0;
		
		for (int i = 0; i < books.length; i++) {
			if(books[i]!=null){
				all++;
				
				if(books[i] instanceof KidBook){
					kid++;
				}
				else{
					if(books[i] instanceof ItBook){
						it++;
					}
					else{
						other++;
					}
				}
				
			}
		}
		
		System.out.println("Ukupno knjiga u knjizari: "+all+" \nDjecije knjige: "+kid+"\nIt knjige: "+it+"\n Ostale knjige: "+other);
	}
	
	public void showRandom(){
		Random r = new Random();
		boolean yes=true;
		while(yes){
			int no = r.nextInt(maxBooks);
			
			if(books[no]!=null){
				System.out.println(books[no].toString());
				yes=false;
			}
		}
	}
	
	public void showKids(int age){
		if(age>0){
			for (int i = 0; i < books.length; i++) {
				if(books[i]!=null){
					if(books[i] instanceof KidBook){
						KidBook k = (KidBook) books[i];
						if(k.getAge()<=age){
							System.out.println("- "+k.getName());
						}
					}
				}
			}
		}
		else{
			System.out.println("Godine nisu u redu.");
		}
	}
	
	public void showIt(){
		int no=0;
		
			for (int i = 0; i < books.length; i++) {
				if(books[i]!=null){
					if(books[i] instanceof ItBook){
						ItBook ii = (ItBook) books[i];
						if(ii.isCd()){
							no++;
						}
					}
				}
			}
			System.out.println("Broj It knjiga uz koje dolazi CD: "+no);
		}
	
	public void averageNumberOfPages(){
		int numberBooks=0;
		int numberOfPages=0;
		
		for (int i = 0; i < books.length; i++) {
			if(books[i]!=null){
				numberBooks++;
				
				numberOfPages+=books[i].getNoOfPages();
			}
		}
		
		System.out.println("Prosjecan broj stranica: ( "+numberOfPages+"/"+numberBooks+") je: "+(numberOfPages/numberBooks));
	}
	
	
	
		
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxBooks() {
		return maxBooks;
	}
	public void setMaxBooks(int maxBooks) {
		this.maxBooks = maxBooks;
	}
	public Book[] getBooks() {
		return books;
	}
	public void setBooks(Book[] books) {
		this.books = books;
	}

	@Override
	public void writeFile(String fileName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String readFile(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
