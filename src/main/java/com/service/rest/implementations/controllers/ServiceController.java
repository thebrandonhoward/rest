package com.service.rest.implementations.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.Response;

import com.service.rest.collaborators.boundaries.SController;
import com.service.rest.collaborators.boundaries.Person;
import com.service.rest.collaborators.boundaries.PersonDAO;

@Named( "serviceController" )
@RequestScoped
public class ServiceController
	implements SController
{

	@Inject @Named( "personDaoImplA" ) PersonDAO personDao;
	
	@Override
	public Response getResource(String id)
	{
		return dispatchSelectResource( id );
	}

	@Override
	public Response getResources(int offset, int limit)
	{
		return dispatchSelectAllResources( offset, limit );
	}

	@Override
	public Response putResource(Person person)
	{
		return dispatchPutResource( person );
	}

	@Override
	public Response postResource(Person person)
	{
		return dispatchPostResource( person );
	}

	@Override
	public Response deleteResource(String id)
	{
		return dispatchDeleteResource( id );
	}

	/*----------------- PRIVATE DISPATCH METHODS ---------------------*/
	
	private Response dispatchSelectResource( String id )
	{
		return personDao.selectPersonById(id);
	}
	
	private Response dispatchSelectAllResources( int offset, int limit )
	{
		return personDao.selectAllPeople( offset, limit );
	}
	
	private Response dispatchPutResource( Person person )
	{
		return personDao.updatePerson( person );
	}
	
	private Response dispatchPostResource( Person person )
	{
		return personDao.insertPerson( person );
	}
	
	private Response dispatchDeleteResource( String id )
	{
		return personDao.deletePerson( id );
	}
	
}
