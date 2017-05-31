public class Test {

	public void test() {
		Application a = new Application("Request for additional exam", "FIT", "marko",
				true);
		System.out.println(a.show());
		System.out.println();

		Application c = new CompanyApplication(
				"Request for funding", "Ministarstvo", "fit",
				false, "fakultet", 10);
		System.out.println(c.show());
		System.out.println();

		PersonApplication p = new PersonApplication(
				"Request for approving the application", "FIT", "janko", true, "23233",
				"STUDENT");
		System.out.println(p.show());
		System.out.println();

		PersonApplication p1 = new PersonApplication(
				"Request for confirmation", "FVU", "janko", false, "23233",
				"STUDENT");
		System.out.println(p1.show());
		System.out.println();

		Archive ar = new Archive("Archive FIT", 10);
		try {
			ar.addApplication(a);
		} catch (AddApplicationException e) {
			System.out.println(e.getMessage());
		}
		try {
			ar.addApplication(c);
		} catch (AddApplicationException e) {
			System.out.println(e.getMessage());
		}
		try {
			ar.addApplication(p);
		} catch (AddApplicationException e) {
			System.out.println(e.getMessage());
		}
		try {
			ar.addApplication(a);
		} catch (AddApplicationException e) {
			System.out.println(e.getMessage());
		}
		try {
			ar.addApplication(p1);
		} catch (AddApplicationException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		System.out.println(ar.show());
		System.out.println();
		// Deleting
		// ar.deleteDenied();
		// System.out.println();
		// System.out.println(ar.show());
		System.out.println("Number of approved: " + ar.countApproved());
		System.out.println();
		System.out.println(ar.findByApplicant("janko"));
		String[] names = { "Marko", "janko" };
		System.out.println("\n Total: " + ar.findByApplicants(names));
		ar.write("archive.txt");
		// Removal
		ar.deleteDenied();
		System.out.println();
		System.out.println(ar.show());
		System.out.println();
		ar.read("archive.txt");
		System.out.println();
		System.out.println(ar.show());

	}
}
