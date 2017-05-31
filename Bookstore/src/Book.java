
public class Book {
	private String name;
	private int noOfPages;
	private int noOfAuthors;
	private String[] authors;
	
	
	public Book(String name, int noOfPages, int noOfAuthors) {
		super();
		this.name = name;
		this.noOfPages = noOfPages;
		this.noOfAuthors = noOfAuthors;
		this.authors = new String[noOfAuthors];
		setAuthors();
	}
	
	public void setAuthors(){
		for (int i = 0; i < authors.length; i++) {
			authors[i]="Unknown";
		}
	}
	
	public void addAuthor(int position, String au){
		int pos = position-1;
		
		if(pos>=0 && pos<noOfAuthors){
			if(authors[pos].equals("Unknown")){
				authors[pos]=au;
			}
			else{
				System.out.println("Pozicija je vec popunjena.");
			}
		}
		else{
			System.out.println("Pozicija nije ispravna.");
		}
		
	}
	
	public void showNameReverse(){
		for (int i = name.length()-1; i >=0; i--) {
			System.out.print(name.charAt(i)+" ");
		}
	}
	
	
	
	@Override
	public String toString() {
		String s = "Book " + name + ", noOfPages: " + noOfPages + ", noOfAuthors: " + noOfAuthors+"\nAutori: \n";
		for (int i = 0; i < authors.length; i++) {
			s+="- "+authors[i]+"\n";
		}
		
		return s;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoOfPages() {
		return noOfPages;
	}
	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}
	public int getNoOfAuthors() {
		return noOfAuthors;
	}
	public void setNoOfAuthors(int noOfAuthors) {
		this.noOfAuthors = noOfAuthors;
	}
	public String[] getAuthors() {
		return authors;
	}
	public void setAuthors(String[] authors) {
		this.authors = authors;
	}
	
	

}
