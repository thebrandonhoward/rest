package com.service.rest.implementations.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.service.rest.collaborators.boundaries.Person;
import com.service.rest.collaborators.boundaries.VController;

@Named( "validationController" )
@RequestScoped
public class ValidationController
	implements VController
{
	
	@Override
	public boolean isValidId(String id)
	{
		return dispatchValidateId( id );
	}

	@Override
	public boolean isValidPerson(Person person)
	{
		return dispatchValidatePerson( person );
	}

	@Override
	public boolean isValidOffsetAndLimit(int offset, int limit)
	{
		return ( dispatchValidateOffset( offset ) && 
				 dispatchValidateLimit( limit ) ) ? true : false;
	}

	@Override
	public boolean isAllValid(String id, Person person )
	{
		return ( dispatchValidateId( id ) && 
				 dispatchValidatePerson( person ) ) ? true : false;
	}

	@Override
	public boolean isAllValid(String id, Person person, int offset, int limit)
	{
		return ( dispatchValidateId( id ) && 
				 dispatchValidatePerson( person ) &&
				 dispatchValidateOffset(offset ) && 
				 dispatchValidateLimit( limit ) ) ? true : false;
	}

	@Override
	public boolean isAllValid(String id, int offset, int limit)
	{
		return ( dispatchValidateId( id ) &&
				 dispatchValidateOffset(offset ) && 
				 dispatchValidateLimit( limit ) ) ? true : false;
	}

	/*----------------- PRIVATE DISPATCH METHODS ---------------------*/
	
	private boolean dispatchValidateId( String id )
	{
		if( id != null )
			return id.replaceAll("[^a-zA-Z0-9]", "#")
					 .equals(id) ? true : false;
			
		return false;
	}
	
	private boolean dispatchValidateOffset( int offset )
	{
		return offset >= 0 ? true : false;
	}
	
	private boolean dispatchValidateLimit( int limit )
	{
		return limit >= 1 && limit <= 5000 ? true : false;
	}
	
	private boolean dispatchValidatePerson( Person person )
	{
		if( person != null )
		{
			if( person.getUsername().length() != 8 )
				return false;
			
			return person.getUsername()
				      	 .replaceAll("[^a-zA-Z0-9]", "#")
				         .equals(person.getUsername()) ? true : false;
		}
		
		return false;
		
	}

}
