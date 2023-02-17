
public class ParkhausMGNT {

	private Ticket ticket1;
	private Ticket ticket2;
	private Ticket ticket3;
	

	private double zuzahlen1;
	int zuzahlen = (int) (zuzahlen1 * 100);

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
		this.ticket1 = null;
		this.ticket2 = null;
		this.ticket3 = null;
	}

	public Ticket getTicket1() {
		return ticket1;
	}

	public void setTicket1(Ticket ticket1) {
		this.ticket1 = ticket1;
	}

	public Ticket getTicket2() {
		return ticket2;
	}

	public void setTicket2(Ticket ticket2) {
		this.ticket2 = ticket2;
	}

	public Ticket getTicket3() {
		return ticket3;
	}

	public void setTicket3(Ticket ticket3) {
		this.ticket3 = ticket3;
	}
	public double getZuzahlen1() {
		return zuzahlen1;
	}

	public void setZuzahlen1(double zuzahlen1) {
		this.zuzahlen1 = zuzahlen1;
	}


	public String getRuckgeld() {
		int zuzahlen = (int) (zuzahlen1 * 100);
		
		mal100 = zuzahlen / 10000;
		zuzahlen = zuzahlen % 10000;
		
		mal50 = zuzahlen / 5000;
		zuzahlen = zuzahlen % 5000;

		mal20 = zuzahlen / 2000;
		zuzahlen = zuzahlen % 2000;

		mal10 = zuzahlen / 1000;
		zuzahlen = zuzahlen % 1000;

		mal05 = zuzahlen / 500;
		zuzahlen = zuzahlen % 500;

		mal02 = zuzahlen / 200;
		zuzahlen = zuzahlen % 200;

		mal01 = zuzahlen / 100;
		zuzahlen = zuzahlen % 100;

		mal050 = zuzahlen / 50;
		zuzahlen = zuzahlen % 50;

		mal020 = zuzahlen / 20;
		zuzahlen = zuzahlen % 20;

		mal010 = zuzahlen / 10;
		zuzahlen = zuzahlen % 10;

		mal005 = zuzahlen / 5;
		zuzahlen = zuzahlen % 5;

		mal002 = zuzahlen / 2;
		zuzahlen = zuzahlen % 2;

		mal001 = zuzahlen / 1;
		zuzahlen = zuzahlen % 1;
		
		
		return "100 Euro schein: " + mal100 + " mal" 
		         + "\n50 Euro schein: " + mal50 + " mal" 
				 + "\n20 Euro schein: " + mal20 + " mal"
		         + "\n10 Euro schein: " + mal10 + " mal" 
			     + "\n5 Euro schein: " + mal05 + " mal"
			     + "\n2 Euro stueck: " + mal02 + " mal" 
		         + "\n1 Euro stueck: " + mal01 + " mal"
			     + "\n0,50 Euro stueck: " + mal050 + " mal"
		         + "\n0,20 Euro stueck: " + mal020 + " mal"
			     + "\n0,10 Euro stueck: " + mal010 + " mal"
		         + "\n0,05 Euro stueck: " + mal005 + " mal"
			     + "\n0,02 Euro stueck: " + mal002 + " mal"
		         + "\n0,01 Euro stueck: " + mal001 + " mal";
	}

	// 3 Tickestslots erstellen
	// verwaltung

}
