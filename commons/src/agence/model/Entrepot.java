package agence.model;

public class Entrepot {
	private long sTotale;
	private String[] equip;
	private BienImmobilier bien;

	public long getsTotale() {
		return sTotale;
	}

	public void setsTotale(long sTotale) {
		this.sTotale = sTotale;
	}

	public String[] getEquip() {
		return equip;
	}

	public void setEquip(String[] equip) {
		this.equip = equip;
	}

	public BienImmobilier getBien() {
		return bien;
	}

	public void setBien(BienImmobilier bien) {
		this.bien = bien;
	}

}
