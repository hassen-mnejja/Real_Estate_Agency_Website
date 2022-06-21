package agence.model;

public class Message {
	private int idMessage;
	private int idEnv;
	private int idRec;
	private String mess;
	private String temps;
	private Client client;

	public int getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}

	public int getIdEnv() {
		return idEnv;
	}

	public void setIdEnv(int idEnv) {
		this.idEnv = idEnv;
	}

	public int getIdRec() {
		return idRec;
	}

	public void setIdRec(int idRec) {
		this.idRec = idRec;
	}

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}

	public String getTemps() {
		return temps;
	}

	public void setTemps(String temps) {
		this.temps = temps;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
