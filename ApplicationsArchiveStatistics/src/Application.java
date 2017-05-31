public class Application {

	private String text;
	private String insitution;
	private String applicant;
	private boolean approved;

	public Application(String text, String insitution, String applicant,
			boolean approved) {
		super();
		this.text = text;
		this.insitution = insitution;
		this.applicant = applicant;
		this.approved = approved;
	}

	public String getText() {
		return text;
	}

	public String getInsitution() {
		return insitution;
	}

	public String getApplicant() {
		return applicant;
	}

	public boolean isApproved() {
		return approved;
	}

	public String show() {
		String name = (applicant.charAt(0) + "").toUpperCase()
				+ applicant.substring(1);
		return "From: " + name + " To: " + insitution + " Text: " + text
				+ " Approved: " + approved;
	}
}
