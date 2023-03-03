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
					System.out.println("Knopf beteatigen fÃ¼r Ticket \t[1]");
					System.out.println("zurÃ¼ck zum Hauptmenu \t\t[2]");
					eingabeEingang = scan.nextInt();
//Neuses ticket
					while (eingabeEingang == 1) {
//überprüfe ob ticket an stelle "i" frei ist
						for (i = 0;p1.ticketliste[i] != null;i++) {
							if (p1.ticketliste[i] == null) {
//erstelle neues ticket
								p1.ticketliste[i] = new Ticket();
//bestätigung ausgeben
								System.out.println("Bitte Ticket entnehmen und durch die Schranke fahren! \n\n");
// i + 1
							} else if (i >= p1.ticketliste.length) {
								//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!//
								i = 0;
								break;
								}
//Wenn ticketslot "i" belegt ist
						}
							while (p1.ticketliste[i] != null) {
								i++;
								if (i >= p1.ticketliste.length) {
									i = 0;
									break;
								}
//ausgabe das voll ist
								System.out.println("Parkhaus ist voll \n\n");
							}

							eingabeEingang = 0;
						}
						if (eingabeEingang == 2) {
							eingabeMenu = 0;
							eingabeEingang = 0;
						}
					}

				}
			}
		}}

}
