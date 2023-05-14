package Parkhaus;

import java.util.*;

public class ParkhausSim {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            Parkhaus p1 = new Parkhaus();
            Kassenautomat k1 = new Kassenautomat(p1);

            int a = 1;
            int eingabeMenu = 0;
            int eingabeEingang = 0;
            int eingabeAusgang = 0;
            int eingabeKasse = 0;
            // menue
            while (a != 0) {
                System.out.println("Willkommen");
                System.out.println("Welches Programm wollen sie Simulieren?");
                System.out.println("Eingang \t [1] \nKasse \t\t [2] \nAusgang \t [3] \n\nBeenden \t [4]");
                eingabeMenu = scan.nextInt();
                if (eingabeMenu == 4) {
                    a = 0;
                }

                // Eingang
                while (eingabeMenu == 1) {
                    System.out.println("Willkommen");
                    System.out.println("Knopf beteatigen für Ticket \t[1]");
                    System.out.println("zurück zum Hauptmenu \t\t[2]");
                    eingabeEingang = scan.nextInt();

                    if (eingabeEingang != 1 && eingabeEingang != 2) {
                        System.out.println("Eingabe nicht erkannt");
                    }
                    if (eingabeEingang == 1) {
                        System.out.println(p1.einfahren());
                        eingabeEingang = 0;
                    }
                    if (eingabeEingang == 2) {
                        eingabeMenu = 0;
                        eingabeEingang = 0;
                    }
                }
                // Kasse
                while (eingabeMenu == 2) {
                    System.out.println("Willkommen");
                    System.out.println("Ticket zahlen: \t\t [1]");
                    System.out.println("Zurück zum Hauptmenue: \t [2]");
                    eingabeKasse = scan.nextInt();
                    if (eingabeKasse == 1) {
                        System.out.println("Was ist ihre Ticketnummer ?");
                        int ke1 = scan.nextInt();
                        Ticket t = p1.getTicket(ke1);
                        if (t.getIstBezahlt() == true){
                        System.out.println("Ticket ist bereits bezahlt");
                        eingabeKasse = 0;
                        } else {
                            System.out.println("Ihre Parkgebuehr betraegt :" + k1.berechnePreis(ke1));
                            System.out.println("Wollen sie jetzt bezahlen?:(Y/N)");
                            char eingabeWillZahlen = scan.next().charAt(0);
                            if (eingabeWillZahlen == 'Y') {
                                System.out.println("Bitte stecken sie Geld in den Automaten!");
                                System.out.println("(nur in der simulation) Wieviel Euro stecken sie in den Automaten?");
                                float gezahlt = scan.nextFloat();
                                while (gezahlt < k1.berechnePreis(ke1)) {
                                    System.out.println("Noch zu zahlen: " + (k1.berechnePreis(ke1) - gezahlt));
                                    System.out
                                            .println("(nur in der simulation) Wieviel Euro stecken sie in den Automaten?");
                                    gezahlt = gezahlt + scan.nextFloat();
                                }
                                if (gezahlt >= k1.berechnePreis(ke1)) {
                                    if (gezahlt > k1.berechnePreis(ke1)) {
                                    System.out.println("sie bekommen zurück :" + (-1*(k1.berechnePreis(ke1) - gezahlt)));
                                    System.out.println(k1.gibWechselgeld(k1.berechnePreis(ke1) - gezahlt));
                                    k1.bezahleTicket(ke1);
                                    } if (gezahlt == k1.berechnePreis(ke1)) {
                                    System.out.println("sie bekommen zurück :" + (k1.berechnePreis(ke1) - gezahlt));
                                    System.out.println(k1.gibWechselgeld(k1.berechnePreis(ke1) - gezahlt));
                                    k1.bezahleTicket(ke1);
                                }}
    
                            }
                            if (eingabeWillZahlen != 'Y' && eingabeWillZahlen != 'N') {
                                System.out.println("eingabe nicht erkannt");
                            }
                            if (eingabeWillZahlen == 'N') {
                                eingabeKasse = 0;
                                eingabeWillZahlen = 'Z';
                            }
                        }
                        
                    }
                    if (eingabeKasse != 0 && eingabeKasse != 1 && eingabeKasse != 2) {
                        System.out.println("eingabe nicht erkannt");
                    }
                    if (eingabeKasse == 2) {
                        eingabeMenu = 0;
                        eingabeKasse = 0;
                    }
                }
                // Ausgang
                while (eingabeMenu == 3) {
                    System.out.println("Willkommen");
                    System.out.println("Schranke öffnen \t\t[1]");
                    System.out.println("zurück zum Hauptmenu \t\t[2]");
                    eingabeAusgang = scan.nextInt();
                    if (eingabeAusgang == 1) {
                        System.out.println("Bitte Geben sie ihre ticketnummer ein");
                        System.out.println(p1.ausfahrt(scan.nextInt()));
                    }
                    if (eingabeAusgang != 1 && eingabeAusgang != 2) {
                        System.out.println("eingabe nicht erkannt");
                    }
                    if (eingabeAusgang == 2) {
                        eingabeMenu = 0;
                        eingabeAusgang = 0;
                    }

                }
            }
        }
    }
}