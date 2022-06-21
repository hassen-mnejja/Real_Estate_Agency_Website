package agence.model;

public class Studio {
	private int etage;
	private String ascenseur;
	private long sTotale;
	private BienImmobilier bien;

	public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public String getAscenseur() {
		return ascenseur;
	}

	public void setAscenseur(String ascenseur) {
		this.ascenseur = ascenseur;
	}

	public long getsTotale() {
		return sTotale;
	}

	public void setsTotale(long sTotale) {
		this.sTotale = sTotale;
	}

	public BienImmobilier getBien() {
		return bien;
	}

	public void setBien(BienImmobilier bien) {
		this.bien = bien;
	}

}
