package agence.model;

public class BienImmobilier {
	private int idBien;
	private int idProp;
	private String statut;
	private String descriptif;
	private Proprietaire prop;
	private String rue;
	private int numero;
	private int codePostal;
	private String region;
	private String delegation;
	private String soumission;
	private String disposition;
	private String typeBien;
	private String modeOffre;
	private long prixDemande;
	private String etat;
	private long caution;
	private long loyer;
	private long charges;
	private String typeBail;
	private String meuble;
	private String caracs[];
	private long prix;
	private int nbImages;

	public int getIdProp() {
		return idProp;
	}

	public void setIdProp(int idProp) {
		this.idProp = idProp;
	}

	public int getIdBien() {
		return idBien;
	}

	public void setIdBien(int idBien) {
		this.idBien = idBien;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public Proprietaire getProp() {
		return prop;
	}

	public void setProp(Proprietaire prop) {
		this.prop = prop;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDelegation() {
		return delegation;
	}

	public void setDelegation(String delegation) {
		this.delegation = delegation;
	}

	public String getSoumission() {
		return soumission;
	}

	public void setSoumission(String soumission) {
		this.soumission = soumission;
	}

	public String getDisposition() {
		return disposition;
	}

	public void setDisposition(String disposition) {
		this.disposition = disposition;
	}

	public String getTypeBien() {
		return typeBien;
	}

	public void setTypeBien(String typeBien) {
		this.typeBien = typeBien;
	}

	public String getModeOffre() {
		return modeOffre;
	}

	public void setModeOffre(String modeOffre) {
		this.modeOffre = modeOffre;
	}

	public long getPrixDemande() {
		return prixDemande;
	}

	public void setPrixDemande(long prixDemande) {
		this.prixDemande = prixDemande;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public long getCaution() {
		return caution;
	}

	public void setCaution(long caution) {
		this.caution = caution;
	}

	public long getLoyer() {
		return loyer;
	}

	public void setLoyer(long loyer) {
		this.loyer = loyer;
	}

	public long getCharges() {
		return charges;
	}

	public void setCharges(long charges) {
		this.charges = charges;
	}

	public String getTypeBail() {
		return typeBail;
	}

	public void setTypeBail(String typeBail) {
		this.typeBail = typeBail;
	}

	public String getMeuble() {
		return meuble;
	}

	public void setMeuble(String meuble) {
		this.meuble = meuble;
	}

	public long getPrix() {
		return prix;
	}

	public void setPrix(long prix) {
		this.prix = prix;
	}

	public String[] getCaracs() {
		return caracs;
	}

	public void setCaracs(String[] caracs) {
		this.caracs = caracs;
	}

	public int getNbImages() {
		return nbImages;
	}

	public void setNbImages(int nbImages) {
		this.nbImages = nbImages;
	}

}
