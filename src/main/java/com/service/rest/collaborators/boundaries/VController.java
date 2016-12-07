package com.service.rest.collaborators.boundaries;

public interface VController
{
	boolean isValidId( String id );
	boolean isValidPerson( Person person );
	boolean isValidOffsetAndLimit( int offset, int limit );
	boolean isAllValid( String id, Person p );
	boolean isAllValid( String id, Person p, int offset, int limit );
	boolean isAllValid( String id, int offset, int limit );
}
