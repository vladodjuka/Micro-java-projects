import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Faculty{
	// TODO Auto-generated constructor stub
	private String name;
	private Set<Student> students;
	
	public Faculty(String name) {
		super();
		this.name = name;
		this.students = new HashSet<Student>();
	}
	
	public boolean add(Student student){
		if(students.contains(student)){
			System.out.println("Vec postoji");
			return false;
		}
		else{
			students.add(student);
			return true;
		}
	}
	
	public boolean remove(Student s){
		if(students.remove(s)){
			return true;
		}
		System.out.println("Ne postoji taj student.");
		return false;
	}
	
	public void show(){
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	public void showIterate(){
		Iterator<Student> i= students.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
	}

}
