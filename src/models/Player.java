package models;

import models.constants.Role;

public class Player {
	
	private Role role;
	private String name;
	private long chips;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getChips() {
		return chips;
	}

	public void setChips(long chip) {
		this.chips = chip;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role){
		this.role = role;
	}
	
	
	

}
