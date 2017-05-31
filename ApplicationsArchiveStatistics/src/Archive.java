import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Archive implements ReadWriteInterface {

	private String name;
	private int maxApplications;
	private Application[] applications;

	public Archive(String name, int maxApplications) {
		super();
		this.name = name;
		this.maxApplications = maxApplications;
		this.applications = new Application[this.maxApplications];
	}

	public boolean addApplication(Application a) throws AddApplicationException {
		if (find(a)) {
			throw new AddApplicationException("Molba od " + a.getApplicant()
					+ " za " + a.getInsitution() + " vec postoji.");
		}
		for (int i = 0; i < applications.length; i++) {
			if (applications[i] == null) {
				applications[i] = a;
				return true;
			}
		}
		throw new AddApplicationException("Nema mjesta za novu molbu.");
	}

	public boolean find(Application a) {
		for (int i = 0; i < applications.length; i++) {
			if (applications[i] != null
					&& applications[i].getApplicant().equalsIgnoreCase(
							a.getApplicant())
					&& applications[i].getInsitution().equalsIgnoreCase(
							a.getInsitution())) {
				return true;
			}
		}
		return false;
	}

	public void deleteDenied() {
		for (int i = 0; i < applications.length; i++) {
			if (applications[i] != null && !applications[i].isApproved()) {
				applications[i] = null;
			}
		}
	}

	public int countApproved() {
		int no = 0;
		for (int i = 0; i < applications.length; i++) {
			if (applications[i] != null && applications[i].isApproved()) {
				no++;
			}
		}
		return no;
	}

	public String findByApplicant(String name) {
		int no = 0;
		int noA = 0;
		int noD = 0;
		for (int i = 0; i < applications.length; i++) {
			if (applications[i] != null
					&& applications[i].getApplicant().equalsIgnoreCase(name)) {
				no++;
				if (applications[i].isApproved()) {
					noA++;
				} else {
					noD++;
				}
			}
		}
		return "Statistics for " + name + ": \nTotal requests: " + no
				+ "\nApproved: " + noA + "\nDenied: " + noD;
	}

	public int findByApplicants(String[] names) {
		int no = 0;
		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < applications.length; j++) {
				if (applications[j] != null
						&& applications[j].getApplicant().equalsIgnoreCase(
								names[i])) {
					no++;
				}
			}
		}
		return no;
	}

	public String show() {
		String result = name + ":";
		for (int i = 0; i < applications.length; i++) {
			if (applications[i] != null) {
				result += "\n" + (i + 1) + ". " + applications[i].show();
			} else {
				result += "\n" + (i + 1) + ". Free place";
			}
		}
		return result;
	}

	@Override
	public void write(String fileName) {
		File f = new File(fileName);
		try {
			PrintStream p = new PrintStream(f);
			p.println(applications.length);
			for (int i = 0; i < applications.length; i++) {
				if (applications[i] != null) {
					String text = applications[i].getApplicant() + "-"
							+ applications[i].getInsitution() + "-"
							+ applications[i].getText() + "-"
							+ applications[i].isApproved();
					p.println(text);
				} else {
					p.println("slobodno");
				}
			}
			p.flush();
			p.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}

	@Override
	public void read(String fileName) {
		File f = new File(fileName);

		try {
			BufferedReader r = new BufferedReader(new FileReader(f));
			int no = Integer.parseInt(r.readLine());
			applications = new Application[no];
			for (int i = 0; i < applications.length; i++) {
				String line = r.readLine();
				if (line.equalsIgnoreCase("slobodno")) {
					applications[i] = null;
				} else {
					String[] data = line.split("-");
					Application a = new Application(data[2], data[1], data[0],
							Boolean.parseBoolean(data[3]));
					applications[i] = a;
				}
			}
			r.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (NumberFormatException e) {
			System.out.println("Not number.");
		} catch (IOException e) {
			System.out.println("Mistake while reading.");
		}

	}
}
