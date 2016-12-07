package com.service.rest.collaborators.boundaries;

import javax.ws.rs.core.Response;

public interface PersonDAO
{
	Response selectAllPeople( int offset, int limit );
	Response selectPersonById( String id );
	Response insertPerson( Person person );
	Response updatePerson( Person person );
	Response deletePerson( String id );
}
