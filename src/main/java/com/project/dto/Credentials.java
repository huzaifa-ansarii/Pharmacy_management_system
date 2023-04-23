package com.project.dto;

public class Credentials {
	private String email;
	private String password;
	//to generate the jwt token
	private String token;
	
	public Credentials() {
		this("", "");
	}
	public Credentials(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return String.format("Credentials [email=%s, password=%s]", email, password);
	}
}
