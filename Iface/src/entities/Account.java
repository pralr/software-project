package entities;
import java.util.ArrayList;
import java.util.List;

import utilities.Community;

public class Account {
	private String login, password, nickname, about, address;
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

	protected Account(String login, String password, String nickname, String about, int age, String address,
			List<String> friends, List<Community> communities, List<String> sendInvitation,
			List<String> receivedInvitation) {
		this.login = login;
		this.password = password;
		this.nickname = nickname;
		this.about = about;
		this.age = age;
		this.address = address;
		this.friends = friends;
		this.communities =  new ArrayList<>();
		this.sendInvitation =  new ArrayList<>();
		this.receivedInvitation =  new ArrayList<>();
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
	
	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
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
		return "Login: " + login + " \n" +
				"Password: " + password + " \n" +
				"Nickname: " + nickname + " \n" +
				"About: " + about + " \n" +
				"Age: " + age + " \n" +
				"Address: " + address;
	}
	
	public void toStringCommunities() {
		for(Community community : communities) {
			System.out.println("-> " + community.getName());
			System.out.println("Description: " + community.getDescription());
			System.out.println("Creator: " + community.getCreator());
		}
	}
	
	public void toStringFriends() {
		for(String friend : friends) {
			System.out.println(friend);
		}
	}
	
}
