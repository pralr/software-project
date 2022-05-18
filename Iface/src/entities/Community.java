package entities;

import java.util.ArrayList;
import java.util.List;

public class Community extends Funcionalities {
	private String creator;
	private List<String> members = new ArrayList<>();
	
	public Community() {
		
	}
	
	public Community(String name, String description, String creator, List<String> members) {
		super.name = name;
		super.description = description;
		this.creator = creator;
		this.members = new ArrayList<>();
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
	public void setDescription(String description) {
		super.description = description;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public List<String> getMembers() {
		return members;
	}
	public void setMembers(List<String> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "------ Community created ------" + " \n"
				+ "Name: " + name + " \n"
				+ "Description: " + description + " \n"
				+ "Creator: " + creator;
	}
	
	
	@Override
	public void printAll() {
		System.out.println("-----------LIST OF MEMBERS------------");
		for(String member : members) {
			System.out.println("Member: " + member);
		}
		System.out.println("--------------------------------------");
	}
	
}