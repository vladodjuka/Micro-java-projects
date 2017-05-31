
public class KidBook extends Book{
	private int age;

	public KidBook(String name, int noOfPages, int noOfAuthors, int age) {
		super(name, noOfPages, noOfAuthors);
		setAge(age);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age>=1 && age<=14){
			this.age=age;
		}
		else{
			this.age=1;
		}
	}
	
	@Override
	public String toString() {
		return super.toString() +"\nUzrast: "+age;
	}
	
	

}
