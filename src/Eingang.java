import java.util.Scanner;

public class Eingang {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// Attribute etc.
		int a = 1;
		int eingabe1 = 0;
		int eingabe2 = 0;
		int eingabe3 = 0;
		int min = 0;
		double parkgebuehr = 0;
		float gezahlt = 0;
		double rückgeldgeld = 0;

		ParkhausMGNT p1 = new ParkhausMGNT();
		Ticket t1 = new Ticket();
		Ticket t2 = new Ticket();
		Ticket t3 = new Ticket();

		// Start menu
		while (a != 0) {
			System.out.println("Willkommen");
			System.out.println("Welches Programm wollen sie Simulieren?");
			System.out.println("Eingang \t [1] \nKasse \t\t [2] \nAusgang \t [3] \n\nBeenden \t [4]");
			eingabe1 = scan.nextInt();
			if (eingabe1 == 4) {
				a = 0;
			}
			// ende menu
			// Eingangs Start
			while (eingabe1 == 1) {
				System.out.println("Willkommen");
				System.out.println("Knopf beteatigen für Ticket \t[1]");
				System.out.println("zurück zum Hauptmenu \t\t[2]");
				eingabe2 = scan.nextInt();
				// neues ticket
				if (eingabe2 == 1) {

					if (p1.getTicket1() == null) {
						// erster ticket slot
						p1.setTicket1(t1);
						System.out.println("Bitte Ticket entnehmen und durch die Schranke fahren! \n\n");
						// zweiter ticket slot
					} else if (p1.getTicket2() == null) {

						p1.setTicket2(t2);
						System.out.println("Bitte Ticket entnehmen und durch die Schranke fahren! \n\n");
						// dritter ticket slot
					} else if (p1.getTicket3() == null) {

						p1.setTicket3(t3);
						System.out.println("Bitte Ticket entnehmen und durch die Schranke fahren! \n\n");
						// Wenn alle ticket slots voll
					} else {
						System.err.println("!!Parkhaus ist voll!!\n\n");
					}
				}
				// eingaben zurücksetzen
				if (eingabe2 == 2) {
					eingabe1 = 0;
					eingabe2 = 0;
				}

			}
			// eingang ende
			// Kasse start
			// Welches ticket abfrage
			while (eingabe1 == 2) {
				System.out.println("Willkommen");
				System.out.println("Bitte stecken sie das Ticket in die dafür vorgesehene Öffnung");
				System.out.println("(nur in der simulation)welches ticket wollen sie simulieren [1],[2],[3]");
				System.out.println("zurück zum Hauptmenu \t[15]");
				eingabe3 = scan.nextInt();
				// Ticket 1
				if (eingabe3 == 1 && t1.getBezahlt() == false) {
					t1.setDatKasse(DateHelper.getCurrentTimeAsString());
					parkgebuehr = 2;
					if (DateHelper.calculateTimeDifferenceInMinutes(t1.getDatEingang(), t1.getDatKasse()) >= 60) {
						parkgebuehr = parkgebuehr + Math.round(
								(DateHelper.calculateTimeDifferenceInMinutes(t1.getDatEingang(), t1.getDatKasse()) / 30)
										* 0.50);
					}
					if (t1.getBezahlt() == false) {
						System.out.println("Ihre Parkgebuehr betraegt :" + parkgebuehr);
						System.out.println("(nur in der simulation) Wieviel Euro stecken sie in den Automaten?");
						gezahlt = scan.nextFloat();
						while (gezahlt < parkgebuehr) {
							System.out.println("Noch zu zahlen: " + (parkgebuehr - gezahlt));
							System.out.println("(nur in der simulation) Wieviel Euro stecken sie in den Automaten?");
							gezahlt = gezahlt + scan.nextFloat();

						}

					}
					p1.setZuzahlen1(gezahlt - parkgebuehr);
					System.out.println("sie bekommen zurück :" + p1.getZuzahlen1());
					System.out.println(p1.getRuckgeld());

					
					
				}
				if (eingabe3 == 1 && t1.getBezahlt() == true) {
					System.out.println("Ihr gewähltes Ticket ist bereits bezahlt");
				}
				if (gezahlt - parkgebuehr >= 0) {
					t1.setBezahlt(true);
				}

				// Ticket 2
				if (eingabe3 == 2) {
					t1.setDatKasse(DateHelper.getCurrentTimeAsString());
					parkgebuehr = 2;
					if (DateHelper.calculateTimeDifferenceInMinutes(t1.getDatEingang(), t1.getDatKasse()) >= 60) {
						parkgebuehr = parkgebuehr + Math.round(
								(DateHelper.calculateTimeDifferenceInMinutes(t1.getDatEingang(), t1.getDatKasse()) / 30)
										* 0.50);
					}
					System.out.println("Ihre Parkgebuehr betraegt :" + parkgebuehr);
					System.out.println("(nur in der simulation) Wieviel Euro stecken sie in den Automaten?");
					gezahlt = scan.nextFloat();
					while (gezahlt < parkgebuehr) {
						System.out.println("Noch zu zahlen: " + (parkgebuehr - gezahlt));
						System.out.println("(nur in der simulation) Wieviel Euro stecken sie in den Automaten?");
						gezahlt = gezahlt + scan.nextFloat();
						if (gezahlt >= parkgebuehr) {
							t1.setBezahlt(true);
						}
					}
					p1.setZuzahlen1(gezahlt - parkgebuehr);
					System.out.println("sie bekommen zurück :" + p1.getZuzahlen1());
					System.out.println(p1.getRuckgeld());
				}
				// ticket 3
				if (eingabe3 == 3) {
					t1.setDatKasse(DateHelper.getCurrentTimeAsString());
					parkgebuehr = 2;
					if (DateHelper.calculateTimeDifferenceInMinutes(t1.getDatEingang(), t1.getDatKasse()) >= 60) {
						parkgebuehr = parkgebuehr + Math.round(
								(DateHelper.calculateTimeDifferenceInMinutes(t1.getDatEingang(), t1.getDatKasse()) / 30)
										* 0.50);
					}
					System.out.println("Ihre Parkgebuehr betraegt :" + parkgebuehr);
					System.out.println("(nur in der simulation) Wieviel Euro stecken sie in den Automaten?");
					gezahlt = scan.nextFloat();
					while (gezahlt < parkgebuehr) {
						System.out.println("Noch zu zahlen: " + (gezahlt - parkgebuehr));
						System.out.println("(nur in der simulation) Wieviel Euro stecken sie in den Automaten?");
						gezahlt = gezahlt + scan.nextFloat();
						if (gezahlt >= parkgebuehr) {
							t1.setBezahlt(true);
						}
					}
					p1.setZuzahlen1(gezahlt - parkgebuehr);
					System.out.println("sie bekommen zurück :" + p1.getZuzahlen1());
					System.out.println(p1.getRuckgeld());
				}
				// eingaben zurücksetzen
				if (eingabe3 == 15) {
					eingabe1 = 0;
					eingabe2 = 0;
					eingabe3 = 0;
				}

			}
			// Kasse ende
			// Ausgang Start

		}
	}
}
