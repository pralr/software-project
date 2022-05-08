package utilities;

import java.util.ArrayList;

public class Community {
	protected String name; 
	protected String description; 
	protected String creator; 
	protected ArrayList<String> members;
	
	public Community() {
		
	}
	
	public Community(String name, String description, String creator, ArrayList<String> members) {
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
	public ArrayList<String> getMembers() {
		return members;
	}
	public void setMembers(ArrayList<String> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "------ Community created ------"
				+ "Name: " + name + ", "
				+ "Description: " + description + ", "
				+ "Creator: " + creator;
	}
	
}
