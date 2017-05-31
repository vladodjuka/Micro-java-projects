import java.sql.*;

public class DatabaseConnection {

	private String url;
	private String user;
	private String pass;
	private Connection conn;

	public DatabaseConnection(String url, String user, String pass) {
		super();
		this.url = url;
		this.user = user;
		this.pass = pass;
		try {
			this.conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			System.out.println("Greska u konekciji.");
		}
	}

	public boolean close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				return false;
			}
		}
		return true;
	}

	public int findTypeMaxId() {
		String sql = "select max(id) as max from type;";
		Statement s;
		try {
			s = conn.createStatement();
			ResultSet result = s.executeQuery(sql);
			int id = 0;
			while (result.next()) {
				id = result.getInt("max");
			}
			result.close();
			return id;
		} catch (SQLException e) {
			return 0;
		}
	}

	public int findBookMaxId() {
		String sql = "select max(id) as max from book;";
		Statement s;
		try {
			s = conn.createStatement();
			ResultSet result = s.executeQuery(sql);
			int id = 0;
			while (result.next()) {
				id = result.getInt("max");
			}
			result.close();
			return id;
		} catch (SQLException e) {
			return 0;
		}
	}

	public boolean insertType(String type) {
		int id = findTypeMaxId() + 1;
		if (findTypeId(type) != 0) {
			System.out.println("Tip " + type + " vec postoji.");
			return false;
		}
		String sql = "INSERT INTO type VALUES(" + id + ",'" + type + "')";
		Statement s;
		try {
			s = conn.createStatement();
			s.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			System.out.println("Greska u upitu.");
			return false;
		}
	}

	public int findTypeId(String type) {
		String sql = "SELECT id FROM type WHERE type = '" + type + "';";
		Statement s;
		try {
			s = conn.createStatement();
			ResultSet result = s.executeQuery(sql);
			int id = 0;
			while (result.next()) {
				id = result.getInt("id");
			}
			result.close();
			return id;
		} catch (SQLException e) {
			System.out.println("Greska u upitu");
			return 0;
		}
	}

	public boolean insertBook(String title, String author, String type) {
		int id = findBookMaxId() + 1;
		int idType = findTypeId(type);
		if (idType == 0) {
			return false;
		}

		String sql = "INSERT INTO book VALUES(" + id + ",'" + title + "','" + author + "'," + idType + ")";
		Statement s;
		try {
			s = conn.createStatement();
			s.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			System.out.println("Greska u upitu.");
			return false;
		}
	}

	public String allBooks() {
		String sql = "select b.title, b.author, t.type FROM book b, type t" + " WHERE b.fk_type=t.id";
		Statement s;
		try {
			s = conn.createStatement();
			ResultSet result = s.executeQuery(sql);
			String resultS = "";
			String title = "";
			String author = "";
			String type = "";
			while (result.next()) {
				title = result.getString("title");
				author = result.getString("author");
				type = result.getString("type");
				resultS += title + ", " + author + " - " + type + "\n";
			}
			result.close();
			return resultS;
		} catch (SQLException e) {
			System.out.println("Greska u upitu");
			return null;
		}
	}

	public int countByType(String type) {
		String sql = "select count(b.id) as count FROM book b, type t" + " WHERE b.fk_type=t.id AND t.type = '" + type
				+ "';";
		Statement s;
		try {
			s = conn.createStatement();
			ResultSet result = s.executeQuery(sql);
			int no = 0;
			while (result.next()) {
				no = result.getInt("count");
			}
			result.close();
			return no;
		} catch (SQLException e) {
			System.out.println("Greska u upitu");
			return 0;
		}
	}

	public String statsByType() {
		String sql = "SELECT count(*) as count, t.type" + " FROM book b, type t" + " WHERE b.fk_type=t.id "
				+ " GROUP BY t.type;";
		Statement s;
		try {
			s = conn.createStatement();
			ResultSet result = s.executeQuery(sql);
			String resultS = "";
			int count = 0;
			String type = "";
			while (result.next()) {
				count = result.getInt("count");
				type = result.getString("type");
				resultS += type + ": " + count + "\n";
			}
			return resultS;
		} catch (SQLException e) {
			System.out.println("Greska u upitu");
			return null;
		}
	}

}
