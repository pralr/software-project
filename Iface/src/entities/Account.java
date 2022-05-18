package entities;
import java.util.ArrayList;
import java.util.List;

public class Account extends Funcionalities 
{
	private String login, password, nickname, address;
	private int age;  
	private List<String> friends = new ArrayList<>();
	private List<Community> communities = new ArrayList<>();
	private List<String> sendInvitation = new ArrayList<>();
	private List<String> receivedInvitation = new ArrayList<>();
	
	public Account() {
		
	}

	public Account(String login, String password, String nickname) {
		this.login = login;
		this.password = password;
		this.nickname = nickname;
		
	}

	protected Account(String login, String password, String nickname, String description, int age, String address,
			List<String> friends, List<Community> communities, List<String> sendInvitation,
			List<String> receivedInvitation) {
		this.login = login;
		this.password = password;
		this.nickname = nickname;
		this.description = description;
		this.age = age;
		this.address = address;
		this.friends = friends;
		this.communities =  new ArrayList<>();
		this.sendInvitation =  new ArrayList<>();
		this.receivedInvitation =  new ArrayList<>();
	}

	public String getName() {
		return super.name;
	}
	
	public void setName(String name) {
		super.name = name;
	}
	
	public String getDescription() {
		return super.description;
	}

	public void setAbout(String description) {
		super.description = description;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	public List<String> getSendInvitation() {
		return sendInvitation;
	}

	public void setSendInvitation(List<String> sendInvitation) {
		this.sendInvitation = sendInvitation;
	}

	public List<String> getReceivedInvitation() {
		return receivedInvitation;
	}

	public void setReceivedInvitation(List<String> receivedInvitation) {
		this.receivedInvitation = receivedInvitation;
	}
	

	public List<Community> getCommunities() {
		return communities;
	}

	public void setCommunities(List<Community> communities) {
		this.communities = communities;
	}

	@Override
	public String toString() {
		return  "Name: " + super.name + "\n" +
				"Login: " + login + " \n" +
				"Password: " + password + " \n" +
				"Nickname: " + nickname + " \n" +
				"About: " + super.description + " \n" +
				"Age: " + age + " \n" +
				"Address: " + address;
	}
	
	public void toStringFriends() {
		System.out.println("--------LIST OF FRIENDS---------------");
		for(String friend : friends) {
			System.out.println(friend);
		}
		System.out.println("--------------------------------------");
	}

	@Override
	public void printAll() {
		System.out.println("--------LIST OF COMMUNITIES-----------");
		for(Community community : communities) {
			System.out.println("Community: " + community.getName());
		}
		System.out.println("--------------------------------------");
	}

}