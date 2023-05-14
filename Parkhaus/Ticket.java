package Parkhaus;

public class Ticket{
    private static int ticketnummer = 0;

    private int ticketID;
    private String dateEingang;
    private boolean istBezahlt;

    public Ticket(int id,String dateEingang,boolean istBezahlt) {
        this.ticketID = ++ticketnummer;
        this.dateEingang = dateEingang;
        this.istBezahlt = istBezahlt;
    }
    public Ticket() {
        this.ticketID = ++ticketnummer;
        this.dateEingang = DateHelper.getActualTimeAsString();
        this.istBezahlt = false;
    }
    //getter
    public int getTicketID() {
        return this.ticketID;
    } 
    public String getDateEingang() {
        return this.dateEingang;
    }
    public boolean getIstBezahlt() {
        return this.istBezahlt;
    }
    //setter
    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }
    public void setDateEingang(String dateEingang) {
        this.dateEingang = dateEingang;
    }
    public void setIstBezahlt(boolean istBezahlt) {
        this.istBezahlt = istBezahlt;
    }
}
