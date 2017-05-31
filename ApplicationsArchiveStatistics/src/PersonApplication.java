public class PersonApplication extends Application {

	private String id;
	private String occupation;

	public PersonApplication(String text, String insitution, String applicant,
			boolean approved,String id,String occupation) {
		super(text, insitution, applicant, approved);
		this.id = id;
		this.occupation = occupation;
	}
	
	@Override
	public String show() {
		return super.show() + " Person occupation: " + occupation.toLowerCase();
	}
}
