package agence.model;

public class Maison {
	private int nbChambres;
	private int nbGarages;
	private int nbEtages;
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

	public int getNbEtages() {
		return nbEtages;
	}

	public void setNbEtages(int nbEtages) {
		this.nbEtages = nbEtages;
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
