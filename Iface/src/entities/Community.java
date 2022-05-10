package entities;

import java.util.ArrayList;
import java.util.List;

public class Community {
	private String name, description, creator;
	private List<String> members = new ArrayList<>();
	
	public Community() {
		
	}
	
	public Community(String name, String description, String creator, List<String> members) {
		this.name = name;
		this.description = description;
		this.creator = creator;
		this.members = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	
}