
public class ParkhausMGNT {

	Ticket[] ticketliste = new Ticket[3];
	int i = 0;

	private double zuzahlen1;
//	int zuzahlen = (int) (zuzahlen1 * 100);

	int a = -1;
	int mal100 = 0;
	int mal50 = 0;
	int mal20 = 0;
	int mal10 = 0;
	int mal05 = 0;
	int mal02 = 0;
	int mal01 = 0;
	int mal050 = 0;
	int mal020 = 0;
	int mal010 = 0;
	int mal005 = 0;
	int mal002 = 0;
	int mal001 = 0;

	public ParkhausMGNT() {
		ticketliste[i] = null;
	}

//	public Ticket getTicket(int a) {
//		if (i == a) ;   // if (a < ticketliste.length)
//			return ticketliste[i];
//	}
	public double getZuzahlen1() {
		return zuzahlen1;
	}

	public void setZuzahlen1(double zuzahlen1) {
		this.zuzahlen1 = zuzahlen1;
	}

	public String getRuckgeld() {

		int zuzahlen = (int) (zuzahlen1 * 100);
		int[] arr1 = { 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1 };
		int[] arr2 = { mal100, mal50, mal20, mal10, mal05, mal02, mal01, mal050, mal020, mal010, mal005, mal002,
				mal001 };

		int i = 0;
		while (i < arr1.length) {

			arr2[i] = zuzahlen / arr1[i];
			zuzahlen = zuzahlen % arr1[i];
			i++;
		}
		return "100 Euro schein: " + arr2[0] + " mal" + "\n50 Euro schein: " + arr2[1] + " mal" + "\n20 Euro schein: "
				+ arr2[2] + " mal" + "\n10 Euro schein: " + arr2[3] + " mal" + "\n5 Euro schein: " + arr2[4] + " mal"
				+ "\n2 Euro stueck: " + arr2[5] + " mal" + "\n1 Euro stueck: " + arr2[6] + " mal"
				+ "\n0,50 Euro stueck: " + arr2[7] + " mal" + "\n0,20 Euro stueck: " + arr2[8] + " mal"
				+ "\n0,10 Euro stueck: " + arr2[9] + " mal" + "\n0,05 Euro stueck: " + arr2[10] + " mal"
				+ "\n0,02 Euro stueck: " + arr2[11] + " mal" + "\n0,01 Euro stueck: " + arr2[12] + " mal\n\n";

		// 3 Tickestslots erstellen
		// verwaltung
	}
}
