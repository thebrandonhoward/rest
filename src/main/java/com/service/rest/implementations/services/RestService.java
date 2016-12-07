package com.service.rest.implementations.services;

import javax.inject.Inject;
import javax.inject.Named;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.service.rest.collaborators.boundaries.Manager;
import com.service.rest.collaborators.boundaries.Person;
import com.service.rest.collaborators.boundaries.Service;
/**
 * @author
 * Uses basic auth and container managed security.
 * The credentials are set in the Tomcat conf dir.
 * Changes could be made to point it to a database realm instead of the
 * default realm.
 */

@Path( "/person" )
public class RestService
	implements Service
{

	@Inject @Named( "serviceManager" ) Manager manager;
	
	@Path("/")
	@GET
	@Consumes("application/*")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Override
	public Response get( @DefaultValue("0") @QueryParam("offset") int offset
			            ,@DefaultValue("100") @QueryParam("limit") int limit )
	{
		return manager.get( offset, limit );
	}

	@Path("/{id}")
	@GET
	@Consumes("application/*")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Override
	public Response get( @NotNull @Pattern(regexp = "[a-zA-Z0-9]") 
	                     @PathParam("id") String id )
	{
		return manager.get( id );
	}

	@Path("/")
	@PUT
	@Consumes("application/*")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Override
	public Response put( Person person )
	{
		return manager.put( person );
	}

	@Path("/")
	@POST
	@Consumes("application/*")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Override
	public Response post( Person person )
	{
		return manager.post( person );
	}

	@Path("/{id}")
	@DELETE
	@Consumes("application/*")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Override
	public Response delete( @NotNull @Pattern(regexp = "[a-zA-Z0-9]") 
	                        @PathParam("id") String id )
	{
		return manager.delete( id );
	}

}
