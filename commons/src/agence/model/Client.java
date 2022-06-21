package agence.model;

import java.util.ArrayList;

public class Client {
	private int idClient;
	private String nom;
	private String prenom;
	private String email;
	private String numtel;
	private String password;
	private ArrayList<BienImmobilier> favoris = new ArrayList<BienImmobilier>();

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumtel() {
		return numtel;
	}

	public void setNumtel(String numtel) {
		this.numtel = numtel;
	}

	public ArrayList<BienImmobilier> getFavoris() {
		return favoris;
	}

	public void setFavoris(ArrayList<BienImmobilier> favoris) {
		this.favoris = favoris;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
