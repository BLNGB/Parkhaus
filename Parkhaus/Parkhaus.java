public class Parkhaus {
    // atribute
    private int anzahlStellplaetze;
    private int anzahlBelegteStellplaetze;
    private Ticket[] ticketliste = new Ticket[3];

    // konstruktor
    public Parkhaus() {
        this.anzahlStellplaetze = 3;
        this.anzahlBelegteStellplaetze = 0;
    }

    // getter
    public int getAnzahlStellplaetze() {
        return this.anzahlStellplaetze;
    }

    public int getAnzahlBelegteStellplaetze() {
        return this.anzahlBelegteStellplaetze;
    }

    public Ticket[] getTicketliste() {
        return this.ticketliste;
    }

    // setter
    public void setAnzahlStellplaetze(int anzahlStellplaetze) {
        this.anzahlStellplaetze = anzahlStellplaetze;
    }

    public void setAnzahlBelegteStellplaetze(int anzahlBelegteStellplaetze) {
        this.anzahlBelegteStellplaetze = anzahlBelegteStellplaetze;
    }

    // methoden
    public String einfahren() {
        int i = 0;
        String meldung = "error";
        while (i + 1 <= this.ticketliste.length) {
            if (this.ticketliste[i] != null) {
                i++;
            } else if (this.ticketliste[i] == null) {
                this.ticketliste[i] = new Ticket();
                this.ticketliste[i].setDateEinfahrt(DateHelper.getActualTimeAsString());
                meldung = "Ihr Ticket hat die Nummer " + this.ticketliste[i].getTicketID()
                        + "\n Bitte Ticket entnehmen und durch die Schranke fahren! \n\n";
            }
            if (i == this.ticketliste.length) {
                meldung = "Parkhaus ist voll \n\n";
            }
        }
        return meldung;
    }

    public String ausfahrt(int ticketId) {
        String meldung = "Ticket nicht erkannt bitte melden sie sich beim Parkhauspersonal";
        Ticket t = this.getTicket(ticketId);
        if (t.getTicketID() == ticketId) {
            if (t.getIstBezahlt() == false) {
                meldung = "Ticket ist noch nicht bezahlt! Bitte bezahlen sie das ticket an einem beliebigen Kassenautomaten.";
            } else {
                meldung = "Bitte fahren sie nun durch die schranke!";
                t = null;
            }
        }

        return meldung;
    }

    public Ticket getTicket(int tId) {
        for (Ticket t : this.ticketliste) {
            if (t.getTicketID() == tId)
                return t;
        }
        return null;
    }
}