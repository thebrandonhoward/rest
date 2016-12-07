package com.service.rest.collaborators.boundaries;

public interface Person
{
	public long getIdNumber();
	public void setIdNumber(long idNumber);
	public String getUsername();
	public void setUsername(String username);
	@Override
	public int hashCode();
	@Override
	public boolean equals(Object obj);
	@Override
	public String toString();	
}
