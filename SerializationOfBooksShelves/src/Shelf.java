import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Shelf implements Serializable{
	private static final long serialVersionUID = 6522646557258598972L;
	private int noOfBooks;
	private Book[] books;
	
	public Shelf(int noOfBooks) {
		super();
		this.noOfBooks = noOfBooks;
		this.books = new Book[noOfBooks];
	}
	
	public void add(Book b){
		for (int i = 0; i < books.length; i++) {
			if(books[i]==null){
				books[i] = b;
				return;
			}
		}
	}
	
	public void showAll(){
		for (int i = 0; i < books.length; i++) {
			if(books[i]!=null){
			System.out.println(books[i]);
			}
		}
	}
	
	public void serialize(String fileName){
		try {
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(fileName));
			o.writeObject(this);
			o.flush();
			o.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static Shelf deserialize(String fileName){
		try {
			ObjectInputStream o = new ObjectInputStream(new FileInputStream(fileName));
			Shelf shelf = (Shelf) o.readObject();
			o.close();
			return shelf;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public int getNoOfBooks() {
		return noOfBooks;
	}

	public void setNoOfBooks(int noOfBooks) {
		this.noOfBooks = noOfBooks;
	}

	public Book[] getBooks() {
		return books;
	}

	public void setBooks(Book[] books) {
		this.books = books;
	}
	
	
	
	

}
