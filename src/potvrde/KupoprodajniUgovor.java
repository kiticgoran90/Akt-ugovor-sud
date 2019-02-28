package potvrde;
import greske.*;

public class KupoprodajniUgovor extends Akt {
	private Osoba prodavac, kupac;
	
	public KupoprodajniUgovor(Osoba prodavac, Osoba kupac) throws GIstaOsoba {
		super("Kupoprodajni ugovor");
		if((this.prodavac = prodavac) == (this.kupac = kupac)) throw new GIstaOsoba();
	}
	
	public Osoba prodavac() {return prodavac;}
	
	public Osoba kupac() {return kupac;}
}
