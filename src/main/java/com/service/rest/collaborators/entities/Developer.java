package com.service.rest.collaborators.entities;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.google.gson.Gson;
import com.service.rest.collaborators.boundaries.Person;

@Named( "developerA" )
@RequestScoped()
public class Developer
	implements Serializable, Person
{

	private static final long serialVersionUID = -3669918590435783094L;
	
	private long idNumber;
	private String username;
	
	public long getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(long idNumber) {
		this.idNumber = idNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idNumber ^ (idNumber >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Developer other = (Developer) obj;
		if (idNumber != other.idNumber)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		Developer d = new Developer();
		d.setIdNumber(this.idNumber);
		d.setUsername(this.username);
		return new Gson().toJson(d);
	}
		
}
