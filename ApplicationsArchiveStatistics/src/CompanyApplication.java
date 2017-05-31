public class CompanyApplication extends Application {

	private String type;
	private int noOfEmployees;

	public CompanyApplication(String text, String insitution, String applicant,
			boolean approved, String type, int noOfEmployees) {
		super(text, insitution, applicant, approved);
		this.type = type;
		this.noOfEmployees = noOfEmployees;
	}
	
	@Override
	public String show() {
		return super.show() + " Company type: " + type.toUpperCase();
	}
}
