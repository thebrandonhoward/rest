package com.service.rest.collaborators.boundaries;

import javax.ws.rs.core.Response;

public interface Manager
{
	Response get( String id );
	Response get( int offset, int limit );
	Response put( Person person );
	Response post( Person person );
	Response delete( String id );	
}
