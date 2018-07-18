package com.qa.persistence;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.persistence.domain.Account;
import com.qa.persistence.domain.Transaction;
import com.qa.persistence.repository.AccountDBRepository;
import com.qa.util.JSONUtil;


@RunWith(MockitoJUnitRunner.class)
public class AccountDBRepositoryTest {

	private static final String MOCK_DATA_ARRAY = "[{\"firstName\":\"John\",\"secondName\":\"Doe\",\"accountNumber\":\"123456\",\"transaction\":[]}]";
	
	private static final String MOCK_OBJECT = "{\"firstName\":\"John\",\"secondName\":\"Doe\",\"accountNumber\":\"123456\",\"transaction\":[]}";
	
	@InjectMocks
	private AccountDBRepository repo;
	
	@Mock 
	private EntityManager manager;
	
	@Mock
	private Query query;
	
	private JSONUtil util;
	
	@Before
	public void setUp() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}
	
	@Test
	public void testGetAllAccounts() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Account> accounts = new ArrayList<Account>();
		List<Transaction> transaction = new ArrayList<Transaction>();
		accounts.add(new Account("John", "Doe", "123456", transaction));
		Mockito.when(query.getResultList()).thenReturn(accounts);
		assertEquals(MOCK_DATA_ARRAY, repo.getAllAccounts());	
	}
	
	@Test
	public void testCreateAccount() {
		String reply = repo.createAccount(MOCK_OBJECT);
		assertEquals(reply, "{\"message\": \"account has been sucessfully added\"}");
	}
	
	@Test
	public void testUpdateAccount() {
		String reply = repo.updateAccount(1L, MOCK_OBJECT);
		assertEquals(reply, "{\"message\": \"account sucessfully updated\"}");
	}
	
	@Test
	public void testDeleteAccount() {
		String reply = repo.deleteAccount(1L);
		assertEquals(reply, "{\"message\": \"account sucessfully deleted\"}");
	}

}
