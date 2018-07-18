package com.qa.business;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.business.service.AccountServiceImpl;
import com.qa.persistence.repository.AccountRepository;


@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

	private static final String MOCK_VALUE = "TestValue";
	
	private static final String MOCK_VALUE2 = "TestValue2";
	
	@InjectMocks
	AccountServiceImpl service;
	
	@Mock
	AccountRepository repo;
	
	@Before
	public void setUp() {
		service.setRepo(repo);
	}
	
	@Test
	public void testGetAllAcounts() {
		Mockito.when(repo.getAllAccounts()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.getAllAccounts());
	}
	
	@Test
	public void testCreateAccount() {
		Mockito.when(repo.createAccount(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.addAccount(MOCK_VALUE2));
		Mockito.verify(repo).createAccount(MOCK_VALUE2);
	}
	
	@Test
	public void testUpdateAccount() {
		Mockito.when(repo.updateAccount(1L, MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.updateAccount(1L, MOCK_VALUE2));
		Mockito.verify(repo).updateAccount(1L, MOCK_VALUE2);
	}
	
	@Test
	public void testDeleteAccount() {
		Mockito.when(repo.deleteAccount(1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.deleteAccount(1L));
		Mockito.verify(repo).deleteAccount(1L);
	}

}
