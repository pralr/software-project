package entities;

import java.util.ArrayList;

import utilities.Community;

public class Account {
	protected String login;
	protected String password; 
	protected String nickname;
	protected String about; 
	protected int age; 
	protected String address; 
	protected ArrayList<String> friends = new ArrayList<>();
	protected ArrayList<Community> communities = new ArrayList<>();
	protected ArrayList<String> sendInvitation = new ArrayList<>();
	protected ArrayList<String> receivedInvitation = new ArrayList<>();
	
	public Account() {
		
	}

	public Account(String login, String password, String nickname) {
		this.login = login;
		this.password = password;
		this.nickname = nickname;
		
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
	
	public ArrayList<String> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<String> friends) {
		this.friends = friends;
	}

	public ArrayList<String> getSendInvitation() {
		return sendInvitation;
	}

	public void setSendInvitation(ArrayList<String> sendInvitation) {
		this.sendInvitation = sendInvitation;
	}

	public ArrayList<String> getReceivedInvitation() {
		return receivedInvitation;
	}

	public void setReceivedInvitation(ArrayList<String> receivedInvitation) {
		this.receivedInvitation = receivedInvitation;
	}
	

	public ArrayList<Community> getCommunities() {
		return communities;
	}

	public void setCommunities(ArrayList<Community> communities) {
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