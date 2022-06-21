package agence.model;

public class Appartement {
	private int nbChambres;
	private int nbGarages;
	private int etage;
	private String ascenseur;
	private long sTotale;
	private long sJardin;
	private BienImmobilier bien;

	public int getNbChambres() {
		return nbChambres;
	}

	public void setNbChambres(int nbChambres) {
		this.nbChambres = nbChambres;
	}

	public int getNbGarages() {
		return nbGarages;
	}

	public void setNbGarages(int nbGarages) {
		this.nbGarages = nbGarages;
	}

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

	public long getsJardin() {
		return sJardin;
	}

	public void setsJardin(long sJardin) {
		this.sJardin = sJardin;
	}

	public BienImmobilier getBien() {
		return bien;
	}

	public void setBien(BienImmobilier bien) {
		this.bien = bien;
	}

}
