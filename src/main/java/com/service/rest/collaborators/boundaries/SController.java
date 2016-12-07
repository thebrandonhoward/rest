package com.service.rest.collaborators.boundaries;

import javax.ws.rs.core.Response;

public interface SController
{
	Response getResource( String id );
	Response getResources( int offset, int limit );
	Response putResource( Person person );
	Response postResource( Person person );
	Response deleteResource( String id );
}
