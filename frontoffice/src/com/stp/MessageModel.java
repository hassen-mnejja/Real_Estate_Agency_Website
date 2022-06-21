package com.stp;
import java.util.ArrayList;
import java.util.List;
public class MessageModel {
    private Mess message=new Mess();
    private List<Mess> msgs = new ArrayList<>();
    public Mess getMessage() {
		return message;
	}
	public void setMessage(Mess message) {
		this.message = message;
	}
	public List<Mess> getMsgs() {
		return msgs;
	}
	public void setMsgs(List<Mess> msgs) {
		this.msgs = msgs;
	}
	
    
    
    		
}
