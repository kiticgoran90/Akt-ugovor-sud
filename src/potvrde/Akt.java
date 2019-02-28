package potvrde;

public abstract class Akt implements Potvrda, Cloneable {
	private static int ID = 0;
	private int id = ++ID;
	private String naziv;
	private boolean original = true;
	
	public Akt(String n) {
		naziv = n;
	}
	
	@Override
	public String naziv() {return naziv;}
	
	@Override
	public int id() {return id;}
	
	public Akt clone() throws CloneNotSupportedException {
		if(!original) throw new CloneNotSupportedException();
		Akt akt = (Akt)super.clone();
		akt.original = false;
		return akt;
	}
	
	public String toString() {
		return naziv + "(" + id + ")" + (original ? "" : " - duplikat"); 
	}
}
