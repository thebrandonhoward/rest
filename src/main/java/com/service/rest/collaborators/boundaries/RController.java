package com.service.rest.collaborators.boundaries;

import java.util.Map;

import javax.ws.rs.core.Response;

public interface RController
{
	Response build( Map<String,?> map );
}