package agence.model;

public class Visite {
	private BienImmobilier bien;
	private Client client;
	private Agent agent;
	private String date;
	private String heured;
	private String heuref;
	private int idVisite;

	public BienImmobilier getBien() {
		return bien;
	}

	public void setBien(BienImmobilier bien) {
		this.bien = bien;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeured() {
		return heured;
	}

	public void setHeured(String heured) {
		this.heured = heured;
	}

	public String getHeuref() {
		return heuref;
	}

	public void setHeuref(String heuref) {
		this.heuref = heuref;
	}

	public int getIdVisite() {
		return idVisite;
	}

	public void setIdVisite(int idVisite) {
		this.idVisite = idVisite;
	}

}
