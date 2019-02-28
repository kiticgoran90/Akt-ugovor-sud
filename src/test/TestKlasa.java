package test;

import potvrde.*;

public class TestKlasa {
	
	public static void main(String[] args) {
		try {
			OpstinskiSud sud = new OpstinskiSud("Prvi beogradski");
			Osoba goran = new Osoba("Goran", 2808990162519L);
			Osoba zoran = new Osoba("Zoran", 7598622162519L);
			int idList1 = sud.vlasList(goran);
			int idUgovor = sud.kupoProdUgovor(goran, zoran);
			sud.vlasList(goran, idList1).ponisti();
			int idList2 = sud.vlasList(zoran);
			System.out.println(sud.kupoProdUgovor(goran, idUgovor));
			System.out.println(sud.vlasList(goran, idList1));
			System.out.println(sud.vlasList(zoran, idList2));
		}catch(Exception g) {System.out.println(g);}
	}
}
