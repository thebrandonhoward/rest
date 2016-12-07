package com.service.rest.implementations.test;

import javax.inject.Inject;

import org.junit.Test;

import com.service.rest.collaborators.entities.test.CdiTest;

public class Injection
{
	@Inject
	private static CdiTest cdiTest;
	
	@Test
	public void test()
	{
		System.out.println(Injection.cdiTest.getMessage());
	}

}
