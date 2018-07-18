package com.qa.interoperability;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.AccountService;




@RunWith(MockitoJUnitRunner.class)
public class AccountEndpointTest {

	private static final String MOCK_VALUE = "testValue";
	
	private static final String MOCK_VALUE2 = "testValue2";
	
	
	
	@InjectMocks
	private AccountEndpoint endpoint;
	
	@Mock
	private AccountService service;
	
	@Before
	public void setUp() {
		endpoint.setService(service);
	}
	
	
	@Test
	public void testGetAllAccounts() {
		Mockito.when(service.getAllAccounts()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.getAllAccounts());
	}
	
	@Test
	public void testCreateAccount() {
		Mockito.when(service.addAccount(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.addAccount(MOCK_VALUE2));
		Mockito.verify(service).addAccount(MOCK_VALUE2);
	}
	@Test
	public void testUpdateAccount() {
		Mockito.when(service.updateAccount(1L, MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.updateAccount(1L, MOCK_VALUE2));
		Mockito.verify(service).updateAccount(1L, MOCK_VALUE2);
	}
	@Test 
	public void testDeleteAccount() {
		Mockito.when(service.deleteAccount(1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.deleteAccount(1L));
		Mockito.verify(service).deleteAccount(1L);
	}

}
