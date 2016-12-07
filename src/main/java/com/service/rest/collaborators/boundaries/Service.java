package com.service.rest.collaborators.boundaries;

import javax.ws.rs.core.Response;

public interface Service
{
	Response get( int offset, int limit );
	Response get( String id );
	Response put( Person person );
	Response post( Person person );
	Response delete(String id);
}
