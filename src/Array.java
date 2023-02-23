public class Array {  
	public static void main(String[] args) {
		
		Ticket[] ticketliste = new Ticket [250];
		int i = 0;
		while (i<ticketliste.length) {
			ticketliste[i] = new Ticket();
			System.out.println(ticketliste[i]);
			i++;
			
		}
    }
} 