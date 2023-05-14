package Parkhaus;

public class Kassenautomat {
    private Parkhaus parkhaus;

    // konstruktor
    public Kassenautomat(Parkhaus parkhaus) {
        this.parkhaus = parkhaus;
    }

    // getter
    public Parkhaus getParkhaus() {
        return this.parkhaus;
    }

    // setter
    public void setParkhaus(Parkhaus parkhaus) {
        this.parkhaus = parkhaus;
    }

    // methoden
    public void bezahleTicket(int ticketId) {
        Ticket t = parkhaus.getTicket(ticketId);
        t.setIstBezahlt(true);

    }

    public int berechneParkdauer(int ticketId) {

        Ticket t = parkhaus.getTicket(ticketId);
        return DateHelper.calculateTimeDifferenceInMinutes(t.getDateEingang(), DateHelper.getActualTimeAsString());
    }

    public double berechnePreis(int ticketId) {
        Ticket t = parkhaus.getTicket(ticketId);
        double parkgebuehr = 2;
            if (DateHelper.calculateTimeDifferenceInMinutes(t.getDateEingang(),
                    DateHelper.getActualTimeAsString()) >= 60) {
                parkgebuehr = parkgebuehr
                        + Math.round((DateHelper.calculateTimeDifferenceInMinutes(
                                t.getDateEingang(),
                                DateHelper.getActualTimeAsString()) / 30) * 0.50);

            }
        return parkgebuehr;
    }

    public String gibWechselgeld(double zuzahlen1) {

        int zuzahlen = (int) (zuzahlen1 * -100);
		int[] arr1 = { 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1 };
		int[] arr2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0 };

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
    }
}
