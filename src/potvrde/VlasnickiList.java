package potvrde;

public class VlasnickiList extends Akt {
	private Osoba vlasnik;
	private boolean vazeci = true;
	
	public VlasnickiList(Osoba vlasnik) {
		super("Vlasnicki list");
		this.vlasnik = vlasnik;
	}
	
	public Osoba vlasnik() {return vlasnik;}
	
	public boolean vazeci() {return vazeci;}
	
	
	public VlasnickiList ponisti() {
		vazeci = false;
		return this;
	}
	
	public VlasnickiList clone() throws CloneNotSupportedException {
		if(!vazeci) throw new CloneNotSupportedException();
		return (VlasnickiList)super.clone();
	}
}
