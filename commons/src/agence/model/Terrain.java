package agence.model;

public class Terrain {
	private Long sTotale;
	private String affectation;
	private BienImmobilier bien;

	public Long getsTotale() {
		return sTotale;
	}

	public void setsTotale(Long sTotale) {
		this.sTotale = sTotale;
	}

	public String getAffectation() {
		return affectation;
	}

	public void setAffectation(String affectation) {
		this.affectation = affectation;
	}

	public BienImmobilier getBien() {
		return bien;
	}

	public void setBien(BienImmobilier bien) {
		this.bien = bien;
	}

}
