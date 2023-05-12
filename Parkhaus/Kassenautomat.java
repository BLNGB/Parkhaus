public class Kassenautomat {
    private Parkhaus parkhaus;

    //konstruktor
    public Kassenautomat(Parkhaus parkhaus) {
        this.parkhaus = parkhaus;
    }
    //getter
    public Parkhaus getParkhaus() {
        return this.parkhaus;
    } 
    //setter 
    public void setParkhaus(Parkhaus parkhaus) {
        this.parkhaus = parkhaus;
    }
    //methoden
    public void bezahleTicket(int ticketId) {
        
        ticket.setIstBezahlt(true); 

    }






    public int berechneParkdauer(Ticket ticket) {
        return DateHelper.calculateTimeDifferenceInMinutes(ticket.getDateEinfahrt(), DateHelper.getActualTimeAsString());
    }


}
