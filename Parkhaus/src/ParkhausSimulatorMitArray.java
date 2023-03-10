import java.util.Scanner;

public class ParkhausSimulatorMitArray {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			// Attribute etc.
			int i = 0;
			int a = 1;
			int b = -1;
			int eingabeMenu = 0;
			int eingabeEingang = 0;
			int eingabeKasse = 0;

			double parkgebuehr = 0;
			float gezahlt = 0;

			ParkhausMGNT p1 = new ParkhausMGNT();
//menu
			while (a != 0) {
				System.out.println("Willkommen");
				System.out.println("Welches Programm wollen sie Simulieren?");
				System.out.println("Eingang \t [1] \nKasse \t\t [2] \nAusgang \t [3] \n\nBeenden \t [4]");
				eingabeMenu = scan.nextInt();
				if (eingabeMenu == 4) {
					a = 0;
				}
//Eingang
				while (eingabeMenu == 1) {
					System.out.println("Willkommen");
					System.out.println("Knopf beteatigen für Ticket \t[1]");
					System.out.println("zurück zum Hauptmenu \t\t[2]");
					eingabeEingang = scan.nextInt();

					while (eingabeEingang == 1) {
						i = 0;
						while (i + 1 <= p1.ticketliste.length) {
							if (p1.ticketliste[i] != null) {
								i++;
							} else if (p1.ticketliste[i] == null) {
								p1.ticketliste[i] = new Ticket();
								p1.ticketliste[i].setDatEingang(DateHelper.getCurrentTimeAsString());
								System.out.println("Bitte Ticket entnehmen und durch die Schranke fahren! \n\n");
								eingabeEingang = 0;
								break;
							}
							if (i == p1.ticketliste.length) {
								System.out.println("Parkhaus ist voll \n\n");
								eingabeEingang = 0;
								break;
							}
						}
					}
					if (eingabeEingang == 2) {
						eingabeMenu = 0;
						eingabeEingang = 0;
					}

				}
				// Eingang ende
				// Kasse
				while (eingabeMenu == 2) {
					System.out.println("Willkommen");
					System.out.println("Bitte stecken sie das Ticket in die dafuer vorgesehene Oeffnung");
					System.out.println("(nur in der simulation)welches ticket wollen sie simulieren [1 bis "
							+ p1.ticketliste.length + "]");
					System.out.println("zurück zum Hauptmenu \t[300]");
					eingabeKasse = scan.nextInt();
					if (eingabeKasse -1 <= p1.ticketliste.length) {
						i = eingabeKasse - 1;	
					}

					if (p1.ticketliste[i].getBezahlt() == false) {
						p1.ticketliste[i].setDatKasse(DateHelper.getCurrentTimeAsString());
						parkgebuehr = 2;
						if (DateHelper.calculateTimeDifferenceInMinutes(p1.ticketliste[i].getDatEingang(),
								p1.ticketliste[i].getDatKasse()) >= 60) {
							parkgebuehr = parkgebuehr + Math.round(
									(DateHelper.calculateTimeDifferenceInMinutes(p1.ticketliste[i].getDatEingang(),
											p1.ticketliste[i].getDatKasse()) / 30) * 0.50);
						}
						if (p1.ticketliste[i].getBezahlt() == false) {
							System.out.println("Ihre Parkgebuehr betraegt :" + parkgebuehr);
							System.out.println("(nur in der simulation) Wieviel Euro stecken sie in den Automaten?");
							gezahlt = scan.nextFloat();
							while (gezahlt < parkgebuehr) {
								System.out.println("Noch zu zahlen: " + (parkgebuehr - gezahlt));
								System.out
										.println("(nur in der simulation) Wieviel Euro stecken sie in den Automaten?");
								gezahlt = gezahlt + scan.nextFloat();

							}

						}
						p1.setZuzahlen1(gezahlt - parkgebuehr);
						System.out.println("sie bekommen zurück :" + p1.getZuzahlen1());
						System.out.println(p1.getRuckgeld());

					}
					if (p1.ticketliste[i].getBezahlt() == true) {
						System.out.println("Ihr gewaehltes Ticket ist bereits bezahlt \n\n");
					}
					if (gezahlt - parkgebuehr >= 0 && p1.ticketliste[i].getBezahlt() == false) {
						p1.ticketliste[i].setBezahlt(true);
						System.out.println("Ihr Ticket ist bezahlt.\nBitte fahren sie inerhalb 10 minuten aus dem Parkhaus!\n\n");
					}
					if (eingabeKasse == 300) {
						eingabeEingang = 0;
						eingabeMenu = 0;
						eingabeKasse = 0;

					}

				}

			}
		}
	}
}
