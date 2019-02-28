package potvrde;
import greske.*;


public class OpstinskiSud {
	private String naziv;
	private int brPotv = 0;
	 
	public OpstinskiSud(String naziv) {
		this.naziv = naziv;
	}
	
	public int brPotv() {return brPotv;}
	public String naziv() {return naziv;}
	
	private class Elem {
		Potvrda pot;
		Elem sled;
		Elem(Potvrda p) {
			pot = p;
			if(prvi == null) prvi = this; else posl.sled = this;
			posl = this;
		}
	}
	
	private Elem prvi, posl;
	
	public int kupoProdUgovor(Osoba prodavac, Osoba kupac) throws GIstaOsoba {
		KupoprodajniUgovor ugovor = new KupoprodajniUgovor(prodavac, kupac);
		new Elem(ugovor);
		brPotv++;
		return ugovor.id();
	}
	
	public KupoprodajniUgovor kupoProdUgovor(Osoba osoba, int broj) throws GNemaPravo, GNemaPotvrde {
		Elem tek = prvi;
		while(tek!=null && tek.pot.id()!=broj) tek = tek.sled;
		if(tek==null || !(tek.pot instanceof KupoprodajniUgovor)) throw new GNemaPotvrde();
		KupoprodajniUgovor ugovor = (KupoprodajniUgovor)tek.pot;
		if(osoba!=ugovor.prodavac() && osoba!=ugovor.kupac()) throw new GNemaPravo();
		try {
			return (KupoprodajniUgovor)ugovor.clone();
		}catch(CloneNotSupportedException g) {return null;}	
	}
	
	public int vlasList(Osoba osoba) {
		VlasnickiList list = new VlasnickiList(osoba);
		new Elem(list);
		brPotv++;
		return list.id();
	}
	
	public VlasnickiList vlasList(Osoba osoba, int broj) throws GNemaPotvrde, GNemaPravo{
		Elem tek = prvi;
		while(tek!=null && tek.pot.id()!=broj) tek=tek.sled;
		if(tek==null || !(tek.pot instanceof VlasnickiList)) throw new GNemaPotvrde();
		VlasnickiList list = (VlasnickiList)tek.pot;
		if(osoba!=list.vlasnik()) throw new GNemaPravo();
		try {
			return list.clone();
		}catch(CloneNotSupportedException g) {return null;}
	}
}
