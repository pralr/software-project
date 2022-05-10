package utilities;

public class CommunityMsg extends Message {
	protected String nameCommunity;

	protected CommunityMsg(String sender, String message, String nameCommunity) {
		super(sender, message);
		this.nameCommunity = nameCommunity;
	}

	public String getCommunity() {
		return nameCommunity;
	}

	public void setCommunity(String nameCommunity) {
		this.nameCommunity = nameCommunity;
	}

}
