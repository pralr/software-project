package utilities;

public class Feed {
	
	protected String feedMessages, sender;
	protected int permission;
	
	public Feed() {
		
	}

	public Feed(String feedMessages, String sender, int permission) {
		this.feedMessages = feedMessages;
		this.sender = sender;
		this.permission = permission;
	}

	public String getFeedMessages() {
		return feedMessages;
	}

	public void setFeedMessages(String feedMessages) {
		this.feedMessages = feedMessages;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

}
