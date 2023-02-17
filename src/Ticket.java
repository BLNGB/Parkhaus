
public class Ticket {
	private static int nummer;

	private int ticketnummer;
	private String datEingang;
	private String datKasse;
	private String datAusgang;
	private boolean bezahlt;

	public Ticket() {
		nummer = nummer + 1;

		this.ticketnummer = nummer;
		this.datEingang = DateHelper.getCurrentTimeAsString();
		this.datKasse = null;
		this.datAusgang = null;
		this.bezahlt = false;
	}
	

	public boolean getBezahlt() {
		return bezahlt;
	}

	public void setBezahlt(boolean bezahlt) {
		this.bezahlt = bezahlt;
	}

	public int getTicketnummer() {
		return ticketnummer;
	}

	public void setTicketnummer(int ticketnummer) {
		this.ticketnummer = ticketnummer;
	}

	public String getDatEingang() {
		return datEingang;
	}

	public void setDatEingang(String datEingang) {
		this.datEingang = datEingang;
	}

	public String getDatKasse() {
		return datKasse;
	}

	public void setDatKasse(String datKasse) {
		this.datKasse = datKasse;
	}

	public String getDatAusgang() {
		return datAusgang;
	}

	public void setDatAusgang(String datAusgang) {
		this.datAusgang = datAusgang;
	}

	@Override
	public String toString() {
		return "Ticket=" + ticketnummer +"[DatEin=" + datEingang + ", datKasse=" + datKasse + ", datAusgang=" + datAusgang + "]";
	}

}
