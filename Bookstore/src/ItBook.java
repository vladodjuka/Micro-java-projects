
public class ItBook extends Book {
	private String tematics;
	private boolean cd;

	public ItBook(String name, int noOfPages, int noOfAuthors, String tematics, boolean cd) {
		super(name, noOfPages, noOfAuthors);
		this.tematics = tematics;
		this.cd = cd;
	}
	
	
	@Override
	public String toString() {
		return super.toString()+"\nTematika: "+tematics+"\n Ukljucen cd: "+cd;
	}


	public String getTematics() {
		return tematics;
	}

	public void setTematics(String tematics) {
		this.tematics = tematics;
	}

	public boolean isCd() {
		return cd;
	}

	public void setCd(boolean cd) {
		this.cd = cd;
	}

}
