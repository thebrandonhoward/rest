package com.service.rest.collaborators.builders;

import java.net.URI;
import java.util.Locale;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.service.rest.collaborators.boundaries.RBuilder;
import com.service.rest.utilities.parameters.RequestKey;

public class ResponseBuilder
	implements RBuilder
{
	private static final String invalidMethod = "GET";
	
	public Response buildResponse( Map<String,?> map )
	{	
		String validMethod = map.get( RequestKey.METHOD ).toString();
		
		switch( (int)map.get( RequestKey.STATUS ) )
		{
			case 200:
				switch (validMethod)
				{
					case "GET":
						return constructSuccessResponse( 
								map.get( RequestKey.PAYLOAD ).toString()
                               ,MediaType.APPLICATION_JSON_TYPE
                               ,map.get( RequestKey.METHOD ).toString()
                               ,(int)map.get( RequestKey.STATUS )
                               ,Locale.ENGLISH );
					default:
						return constructInvalidRequestResponse(
								invalidMethod, Status.BAD_REQUEST
								                     .getStatusCode() );
				}	
				
			case 204:
				switch (validMethod)
				{
					case "HEAD":
						return constructHeadResponse();
					case "OPTIONS":
						return constructOptionsResponse();
					default:
						return constructInvalidRequestResponse(
								invalidMethod, Status.BAD_REQUEST
								                     .getStatusCode() );
				}
				
			default:
				return constructInvalidRequestResponse(
						invalidMethod, Status.BAD_REQUEST.getStatusCode() );
		}
	}

	/*--------------- PRIVATE CONSTRUCT METHODS ---------------------*/
	
	private Response constructSuccessResponse( Object json
			                                  ,MediaType mediaType
			                                  ,String method
			                                  ,int status
			                                  ,Locale language )
	{
		return Response.ok( json, mediaType )
				       .header( "Access-Control-Allow-Origin", "*" )
			           .header( "Access-Control-Allow-Methods", method )
			           .language( language )
			           .status( status )
			           .build();
	}

	private Response constructInvalidRequestResponse( String method
			                                         ,int status )
	{
		return Response.serverError()
		               .header( "Access-Control-Allow-Origin","*" )
	                   .header( "Access-Control-Allow-Methods", method )
	                   .status( status )
	                   .build();
	}

	private Response constructCreatedResponse( String method
	                                          ,int status
	                                          ,URI uri )
	{
		return Response.created( uri )
		               .header( "Access-Control-Allow-Origin","*" )
		               .header( "Access-Control-Allow-Methods", method )
		               .status( status )
		               .build();
	}

	private Response constructHeadResponse()
	{
		return Response.noContent()
				       .header( "Access-Control-Allow-Origin","*" )
				       .header( "Access-Control-Allow-Headers"
              		           ,"Access-Control-Allow-Headers,Accept,"
              		           + "Access-Control-Allow-Origin,subscriberid,consumerid,"
              		           + "userid,version,token,password" )
				       .build();

	}

	private Response constructOptionsResponse()
	{
		return Response.noContent()
				       .header( "Access-Control-Allow-Origin","*" )
				       .header( "Access-Control-Allow-Methods"
		                	   ,"OPTIONS,HEAD,GET,PUT,POST,PATCH,DELETE" )
                       .header( "Access-Control-Allow-Headers"
              		           ,"Access-Control-Allow-Headers,Accept,"
              		           + "Access-Control-Allow-Origin,subscriberid,consumerid,"
              		           + "userid,version,token,password" )
                       .build();
	}

}