package com.liwanag.demo;

import com.liwanag.demo.model.Account;
import com.liwanag.demo.model.Role;
import com.liwanag.demo.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*@Bean
	CommandLineRunner commandLineRunner(AccountRepository accountRepository) {
		return args -> {
			Account account1 = new Account();
			account1.setId(null);
			account1.setFirstname("Rolan");
			account1.setLastname("Liwanag");
			account1.setUsername("rliwanag");
			account1.setPassword("pass123");

			Role role1 = new Role();
			role1.setId(null);
			role1.setName("ADMIN");
			Set<Role> roles1 = new HashSet<>();
			roles1.add(role1);

			account1.setRoles(roles1);
			accountRepository.save(account1);

			Account account2 = new Account();
			account2.setId(null);
			account2.setFirstname("Test");
			account2.setLastname("User");
			account2.setUsername("tuser");
			account2.setPassword("password");

			Role role2 = new Role();
			role2.setName("VISITOR");
			role2.setId(null);

			Set<Role> roles2 = new HashSet<>();
			roles2.add(role2);

			account2.setRoles(roles2);
			accountRepository.save(account2);

			ArrayList<Account> accounts = (ArrayList<Account>) accountRepository.findAllOrderByLastname();
			for(Account a : accounts) {
				System.out.println(a.getLastname());
				a.getRoles().forEach(
						r -> {
							System.out.println(r.getName());
						}
				);
			}
		};
	}*/

}
