package agence.model;

public class Emplacement {
	private int nbPieces;
	private long sTotale;
	private BienImmobilier bien;

	public int getNbPieces() {
		return nbPieces;
	}

	public void setNbPieces(int nbPieces) {
		this.nbPieces = nbPieces;
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
