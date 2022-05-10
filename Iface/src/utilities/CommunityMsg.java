package utilities;

public class CommunityMsg {
	
	protected String sender, message, community;

	public CommunityMsg() {
		
	}
	
	public CommunityMsg(String sender, String message, String community) {
		this.sender = sender;
		this.message = message;
		this.community = community;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

}