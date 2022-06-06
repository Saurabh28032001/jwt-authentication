package com.saurabh.jwt.entities;

public class Response {
	private String jwt;
	
	public Response() {
		
	}

	public Response(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
}
