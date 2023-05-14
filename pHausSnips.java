import java.util.Scanner;

public class ParkhausSimulatorMitArray {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			// Attribute etc.
			int i = 0;
			int a = 1;
//			int b = -1;
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

					if (eingabeEingang != 1 && eingabeEingang != 2) {
						System.out.println("Eingabe nicht erkannt");
					}

					while (eingabeEingang == 1) {
						i = 0;
						while (i + 1 <= p1.ticketliste.length) {
							if (p1.ticketliste[i] != null) {
								i++;
							} else if (p1.ticketliste[i] == null) {
								p1.ticketliste[i] = new Ticket();
								p1.ticketliste[i].setDatEingang(DateHelper.getCurrentTimeAsString());
								System.out.println("Ihr Ticket hat die Nummer " + p1.ticketliste[i].getTicketnummer());
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

				// !!!Ticketliste[i].eingabe nicht Ticketliste[eingabe]
				// !!!
				// !!!

				// Kasse
				while (eingabeMenu == 2) {
					System.out.println("Willkommen");
					System.out.println("Ticket zahlen: \t\t [1]");
					System.out.println("Zurück zum Hauptmenue: \t [2]");
					eingabeKasse = scan.nextInt();
					if (eingabeKasse == 1) {
						System.out.println("Was ist ihre Ticketnummer ?");
						int ticketNr = scan.nextInt();

						for (int j = 0; j < p1.ticketliste.length; j++) {
							if (p1.ticketliste[j].getTicketnummer() != ticketNr) {
								if (j == p1.ticketliste.length) {
									break;
								}
							} else if (p1.ticketliste[j].getTicketnummer() == ticketNr) {
								i = j;

								if (p1.ticketliste[i].getBezahlt() == false) {
									p1.ticketliste[i].setDatKasse(DateHelper.getCurrentTimeAsString());
									parkgebuehr = 2;
									if (DateHelper.calculateTimeDifferenceInMinutes(p1.ticketliste[i].getDatEingang(),
											p1.ticketliste[i].getDatKasse()) >= 60) {
										parkgebuehr = parkgebuehr
												+ Math.round((DateHelper.calculateTimeDifferenceInMinutes(
														p1.ticketliste[i].getDatEingang(),
														p1.ticketliste[i].getDatKasse()) / 30) * 0.50);
									}
									System.out.println("Ihre Parkgebuehr betraegt :" + parkgebuehr);
									System.out.println("Wollen sie jetzt bezahlen?:(Y/N)");
									char eingabeWillZahlen = scan.next().charAt(0);
									
									if (eingabeWillZahlen == 'Y') {
										System.out.println("Bitte stecken sie Geld in den Automaten!");
										System.out.println("(nur in der simulation) Wieviel Euro stecken sie in den Automaten?");
										gezahlt = scan.nextFloat();
										while (gezahlt < parkgebuehr) {
											System.out.println("Noch zu zahlen: " + (parkgebuehr - gezahlt));
											System.out.println(
													"(nur in der simulation) Wieviel Euro stecken sie in den Automaten?");
											gezahlt = gezahlt + scan.nextFloat();
											p1.setZuzahlen1(gezahlt - parkgebuehr);
											System.out.println("sie bekommen zurück :" + p1.getZuzahlen1());
											System.out.println(p1.getRuckgeld());
										}
// Rüchgabe wird nur gegeben wenn weniger als done bezahlt wird !!!
										if (gezahlt - parkgebuehr >= 0 && p1.ticketliste[i].getBezahlt() == false) {
											p1.ticketliste[i].setBezahlt(true);
											System.out.println(
													"Ihr Ticket ist bezahlt.\nBitte fahren sie inerhalb 10 minuten aus dem Parkhaus!\n\n");
										}
									} else {
										eingabeEingang = 0;
										eingabeKasse = 0;
									}

								} else {
									System.out.println("Ihr gewaehltes Ticket ist bereits bezahlt \n\n");
								}
							}
						}
						
//						if (p1.ticketliste[i].getBezahlt() == false) {
//							p1.ticketliste[i].setDatKasse(DateHelper.getCurrentTimeAsString());
//							parkgebuehr = 2;
//							if (DateHelper.calculateTimeDifferenceInMinutes(p1.ticketliste[i].getDatEingang(),
//									p1.ticketliste[i].getDatKasse()) >= 60) {
//								parkgebuehr = parkgebuehr + Math.round(
//										(DateHelper.calculateTimeDifferenceInMinutes(p1.ticketliste[i].getDatEingang(),
//												p1.ticketliste[i].getDatKasse()) / 30) * 0.50);
//							}
//							System.out.println("Ihre Parkgebuehr betraegt :" + parkgebuehr);
//							System.out.println("Wollen sie jetzt bezahlen?:(Y/N)");
//							String eingabeWillZahlen = scan.next();
//							if (eingabeWillZahlen == "Y") {
//								System.out
//										.println("(nur in der simulation) Wieviel Euro stecken sie in den Automaten?");
//								gezahlt = scan.nextFloat();
//								while (gezahlt < parkgebuehr) {
//									System.out.println("Noch zu zahlen: " + (parkgebuehr - gezahlt));
//									System.out.println(
//											"(nur in der simulation) Wieviel Euro stecken sie in den Automaten?");
//									gezahlt = gezahlt + scan.nextFloat();
//									p1.setZuzahlen1(gezahlt - parkgebuehr);
//									System.out.println("sie bekommen zurück :" + p1.getZuzahlen1());
//									System.out.println(p1.getRuckgeld());
//								}
//								if (gezahlt - parkgebuehr >= 0 && p1.ticketliste[i].getBezahlt() == false) {
//									p1.ticketliste[i].setBezahlt(true);
//									System.out.println(
//											"Ihr Ticket ist bezahlt.\nBitte fahren sie inerhalb 10 minuten aus dem Parkhaus!\n\n");
//								}
//							} else {
//								eingabeEingang = 0;
//								eingabeKasse = 0;
//							}
//
//						} else {
//							System.out.println("Ihr gewaehltes Ticket ist bereits bezahlt \n\n");
//						}
						
					}
					if (eingabeKasse == 2) {
						eingabeEingang = 0;
						eingabeMenu = 0;
						eingabeKasse = 0;

					}
				}
			}

		}

	}
}