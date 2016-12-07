package com.service.rest.implementations.daos;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.service.rest.collaborators.boundaries.Person;
import com.service.rest.collaborators.boundaries.PersonDAO;
/**
 * 
 * @author 
 * Database connections should use try with resources.
 *
 */
@Named( "personDaoImplA" )
@RequestScoped
public class PersonDAOImpl
	implements PersonDAO
{
	@Inject @Named("developerA") Person person;
			
	@Override
	public Response selectAllPeople( int offset, int limit )
	{
		person.setIdNumber(1l);
		person.setUsername("user1");
		
		return Response.ok(person, MediaType.APPLICATION_JSON_TYPE)
					   .build();
	}

	@Override
	public Response selectPersonById( String id )
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response insertPerson( Person person )
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response updatePerson( Person person )
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deletePerson( String id )
	{
		// TODO Auto-generated method stub
		return null;
	}

}
