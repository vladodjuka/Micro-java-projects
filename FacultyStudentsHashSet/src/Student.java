
public class Student {
	private String name;
	private String index;
	
	public Student(String name, String index) {
		super();
		this.name = name;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return name + ", index: " + index;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student){
			Student s = (Student) obj;
			if(s.getIndex().equalsIgnoreCase(this.index)){
				return true;
			}
		}
		return false;
	}	
	
	@Override
	public int hashCode() {
		if(index.contains("-") && index.split("-").length>0){
			int no = Integer.parseInt(index.split("-")[0]);
			return no;
		}
		return -1;
	}
	

}
