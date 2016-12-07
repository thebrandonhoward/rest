package com.service.rest.implementations.managers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.Response;

import com.service.rest.collaborators.boundaries.SController;
import com.service.rest.collaborators.boundaries.VController;
import com.service.rest.collaborators.boundaries.Manager;
import com.service.rest.collaborators.boundaries.Person;

@Named( "serviceManager" )
@RequestScoped
public class ServiceManager
	implements Manager
{
	
	@Inject @Named( "serviceController" ) SController sController;
	@Inject @Named( "validationController" ) VController vController;
	
	@Override
	public Response get(int offset, int limit )
	{
		return delegateGetAll( offset, limit );
	}

	@Override
	public Response get(String id)
	{
		return delegateGetById( id );
	}
	
	@Override
	public Response put(Person person)
	{
		return delegatePut( person );
	}

	@Override
	public Response post(Person person)
	{
		return delegatePost( person );
	}

	@Override
	public Response delete(String id)
	{
		return delegateDelete( id );
	}

	/*--------------- PRIVATE DELEGATE METHODS ------------------*/
	
	private Response delegateGetAll( int offset, int limit )
	{
		return ( vController.isValidOffsetAndLimit(offset, limit) ) ? 
					sController.getResources(offset, limit): null; //call response controller with error;
	}
	
	private Response delegateGetById( String id )
	{
		return ( vController.isValidId(id) ) ? 
					sController.getResource(id) : null; //call response controller with error;
	}
	
	private Response delegatePut( Person person )
	{
		return ( vController.isValidPerson(person) ) ? 
					sController.putResource(person) : null; //call response controller with error;
	}
	
	private Response delegatePost( Person person )
	{
		return ( vController.isValidPerson(person) ) ? 
				sController.postResource(person) : null; //call response controller with error;
	}
	
	private Response delegateDelete( String id )
	{
		return ( vController.isValidId(id) ) ? 
				sController.deleteResource(id) : null; //call response controller with error;
	}
	
}
