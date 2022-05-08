package utilities;

public class Message {
	
	protected String sender; 
	protected String receiver; 
	protected String message;
	
	public Message(String sender, String receiver, String message) {
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMessages() {
		return message;
	}

	public void setMessages(String message) {
		this.message = message;
	}  
	
}
