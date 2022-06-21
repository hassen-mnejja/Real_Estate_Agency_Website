package agence.model;

public class Contrat {
	private int numContrat;
	private Client client;
	private BienImmobilier bien;
	private long prix;
	private String date;

	public int getNumContrat() {
		return numContrat;
	}

	public void setNumContrat(int numContrat) {
		this.numContrat = numContrat;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public BienImmobilier getBien() {
		return bien;
	}

	public void setBien(BienImmobilier bien) {
		this.bien = bien;
	}

	public long getPrix() {
		return prix;
	}

	public void setPrix(long prix) {
		this.prix = prix;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
