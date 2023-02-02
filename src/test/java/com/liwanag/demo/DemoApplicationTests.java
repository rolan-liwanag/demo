package com.liwanag.demo;

import com.liwanag.demo.model.Account;
import com.liwanag.demo.model.Role;
import com.liwanag.demo.repository.AccountRepository;
import com.liwanag.demo.service.AccountService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestExecution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DemoApplicationTests {

	@Autowired
	AccountService accountService;

	@Test
	public void shouldGetAccountById() {
		Optional<Account> account =accountService.getAccountById(1);

		assertThat(account.isPresent());
		assertThat(account.get().getUsername().equals("nuzamaki"));
	}

	@Test
	public void shouldGetAllAccounts() {
		ArrayList<Account> accounts = accountService.getAllAccounts();

		assertThat(accounts != null);
		assertThat(accounts.size() > 0);
		assertThat(accounts.get(0).getUsername().equals("nuzamaki"));
	}

	@Test
	public void shouldGetAllAccountsSortByLastname() {
		ArrayList<Account> accounts = accountService.getAllAccountsOrderByLastname();
		assertThat(accounts != null);
		assertThat(accounts.size() > 0);
		assertThat(accounts.get(0).getUsername().equals("sharuno"));
	}

	@Test
	public void shouldCreateNewAccount() {
		ArrayList<Account> accountsBefore = accountService.getAllAccounts();

		Account account = new Account();
		account.setFirstname("Hinata");
		account.setLastname("Hyuga");
		account.setUsername("hhyuga");
		account.setPassword("naruto");

		Role role = new Role();
		role.setName("ADMIN");
		Set<Role> roles = new HashSet<>();
		roles.add(role);

		account.setRoles(roles);
		accountService.createAccount(account);

		ArrayList<Account> accountsAfter = accountService.getAllAccounts();

		assertThat(accountsBefore.size() < accountsAfter.size());
	}

	@Test
	public void duplicateUsernameShouldNotBeAllowed() {
		try {
			Account account = new Account();
			account.setFirstname("Test1");
			account.setLastname("User1");
			account.setUsername("nuzamaki");
			account.setPassword("password1");

			Role role = new Role();
			role.setName("ADMIN");
			Set<Role> roles = new HashSet<>();
			roles.add(role);

			account.setRoles(roles);
			accountService.createAccount(account);
		} catch(Exception e) {
			assertThat(e.getMessage().contains("Unique index or primary key violation"));
		}
	}

	@Test
	public void duplicateFirstnameLastnameShouldNotBeAllowed() {
		try {
			Account account = new Account();
			account.setFirstname("Sasuke");
			account.setLastname("Uchiha");
			account.setUsername("sasukeuchiha");
			account.setPassword("password1");

			Role role = new Role();
			role.setName("ADMIN");
			Set<Role> roles = new HashSet<>();
			roles.add(role);

			account.setRoles(roles);
			accountService.createAccount(account);
		} catch(Exception e) {
			assertThat(e.getMessage().contains("Unique index or primary key violation"));
		}
	}


	@BeforeAll
	public void setUp() {
		Account account1 = new Account();
		account1.setId(null);
		account1.setFirstname("Naruto");
		account1.setLastname("Uzamaki");
		account1.setUsername("nuzamaki");
		account1.setPassword("pass123");

		Role role1 = new Role();
		role1.setId(null);
		role1.setName("ADMIN");
		Set<Role> roles1 = new HashSet<>();
		roles1.add(role1);

		account1.setRoles(roles1);
		accountService.createAccount(account1);

		Account account2 = new Account();
		account2.setId(null);
		account2.setFirstname("Sasuke");
		account2.setLastname("Uchiha");
		account2.setUsername("suchia");
		account2.setPassword("password");

		Role role2 = new Role();
		role2.setId(null);
		role2.setName("USER");
		Set<Role> roles2 = new HashSet<>();
		roles2.add(role2);

		account2.setRoles(roles2);
		accountService.createAccount(account2);

		Account account3 = new Account();
		account3.setId(null);
		account3.setFirstname("Sakura");
		account3.setLastname("Haruno");
		account3.setUsername("sharuno");
		account3.setPassword("pword789");

		Role role3a = new Role();
		role3a.setId(null);
		role3a.setName("USER");
		Role role3b = new Role();
		role3b.setId(null);
		role3b.setName("DEV");
		Set<Role> roles3 = new HashSet<>();
		roles3.add(role3a);
		roles3.add(role3b);

		account3.setRoles(roles3);
		accountService.createAccount(account3);
	}

}
