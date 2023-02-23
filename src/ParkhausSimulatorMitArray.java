import java.util.Scanner;
public class ParkhausSimulatorMitArray {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			// Attribute etc.
			int a = 1;
			int b = -1;
			int eingabe1 = 0;
			int eingabe2 = 0;
			int eingabe3 = 0;

			double parkgebuehr = 0;
			float gezahlt = 0;

			ParkhausMGNT p1 = new ParkhausMGNT();
			
			}
			

			// Start menu
			while (a != 0) {
				System.out.println("Willkommen");
				System.out.println("Welches Programm wollen sie Simulieren?");
				System.out.println("Eingang \t [1] \nKasse \t\t [2] \nAusgang \t [3] \n\nBeenden \t [4]");
				eingabe1 = scan.nextInt();
				if (eingabe1 == 4) {
					a = 0;
				}
				// Eingangs Start
				while (eingabe1 == 1) {
					System.out.println("Willkommen");
					System.out.println("Knopf beteatigen für Ticket \t[1]");
					System.out.println("zurück zum Hauptmenu \t\t[2]");
					eingabe2 = scan.nextInt();
					
					if (eingabe2 == 1) {
						ticketlist[i].
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					// eingaben zurücksetzen
					if (eingabe2 == 2) {
						eingabe1 = 0;
						eingabe2 = 0;
					}

				}
				
				
				
				
				
				
				
				
				
				
				
				
//				// Kasse start
//				// Welches ticket abfrage
//				while (eingabe1 == 2) {
//					System.out.println("Willkommen");
//					System.out.println("Bitte stecken sie das Ticket in die dafür vorgesehene Öffnung");
//					System.out.println("(nur in der simulation)welches ticket wollen sie simulieren [1],[2],[3]");
//					System.out.println("zurück zum Hauptmenu \t[15]");
//					eingabe3 = scan.nextInt();
//						if (eingabe3 == 3 && t3.getBezahlt() == false) {
//							t3.setDatKasse(DateHelper.getCurrentTimeAsString());
//							parkgebuehr = 2;
//							if (DateHelper.calculateTimeDifferenceInMinutes(t3.getDatEingang(), t3.getDatKasse()) >= 60) {
//								parkgebuehr = parkgebuehr + Math.round(
//										(DateHelper.calculateTimeDifferenceInMinutes(t3.getDatEingang(), t3.getDatKasse())
//												/ 30)
//												* 0.50);
//							}
//							if (t3.getBezahlt() == false) {
//								System.out.println("Ihre Parkgebuehr betraegt :" + parkgebuehr);
//								System.out.println("(nur in der simulation) Wieviel Euro stecken sie in den Automaten?");
//								gezahlt = scan.nextFloat();
//								while (gezahlt < parkgebuehr) {
//									System.out.println("Noch zu zahlen: " + (parkgebuehr - gezahlt));
//									System.out
//											.println("(nur in der simulation) Wieviel Euro stecken sie in den Automaten?");
//									gezahlt = gezahlt + scan.nextFloat();
//	
//								}
//	
//							}
//							p1.setZuzahlen1(gezahlt - parkgebuehr);
//							System.out.println("sie bekommen zurück :" + p1.getZuzahlen1());
//							System.out.println(p1.getRuckgeld());
//	
//						}
//						if (eingabe3 == 1 && t3.getBezahlt() == true) {
//							System.out.println("Ihr gewähltes Ticket ist bereits bezahlt");
//						}
//						if (gezahlt - parkgebuehr >= 0) {
//							t3.setBezahlt(true);
//						}
					// eingaben zurücksetzen
					if (eingabe3 == 15) {
						eingabe1 = 0;
						eingabe2 = 0;
						eingabe3 = 0;
					}
				}
			}
		}
	}
}

