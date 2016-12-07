package com.service.rest.collaborators.boundaries;

import java.util.Map;

import javax.ws.rs.core.Response;

public interface RBuilder
{
	public Response buildResponse( Map<String,?> map );
}
