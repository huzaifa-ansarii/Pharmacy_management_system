package com.project.dto;

import com.project.entities.User;

public class AuthResponse {

	private User user;
	private Credentials cred;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Credentials getCred() {
		return cred;
	}
	public void setCred(Credentials cred) {
		this.cred = cred;
	}
	@Override
	public String toString() {
		return "AuthResponse [user=" + user + ", cred=" + cred + "]";
	}
	
}
