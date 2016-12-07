package com.service.rest.implementations.resources;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.service.rest.implementations.services.RestService;

/**
 * 
 * @author
 * Defines the routes in the classes and any singleton Objects.
 * The singletons could be database connections or something.
 *
 */

@ApplicationPath( "services" )
public class DeploymentApplication
	extends Application
{
	
	@Override
	public Set<Class<?>> getClasses()
	{
		Set<Class<?>> set = new HashSet<>();
		set.add(RestService.class);
		
        return set;
    }
	
	@Override
	public Set<Object> getSingletons()
	{
        return Collections.emptySet();
    }
	
	@Override
	public Map<String, Object> getProperties()
	{
        return Collections.emptyMap();
    }
	
}
