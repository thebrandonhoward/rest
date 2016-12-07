package com.service.rest.collaborators.entities.test;

import javax.enterprise.context.RequestScoped;

public class CdiTest
{
	private String message = "CDI is working!";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
