package com.receipt.vault.integration;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.receipt.vault.dao.UserRepository;
import com.receipt.vault.model.User;

@Ignore
@ContextConfiguration("classpath:spring-beans.xml")
public class UserIntegrationTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void saveUser() throws Exception {

		User user = new User("donalredd@gmail.com", "donal Redd", "fdsa");
		userRepository.save(user);
		assertTrue(user.getId() != null);
		System.out.println(user.getId());

	}

	@Test
	public void findsAllUser() throws Exception {
		userRepository.deleteAll();
		User user1 = new User("donalredd@gmail.com1", "donal Redd", "fdsa");
		userRepository.save(user1);
		User user2 = new User("donalredd@gmail.com", "donal Redd", "fdsa");
		userRepository.save(user2);
		assertTrue(userRepository.count() == 2);
	}

	@Test
	public void removeUser() throws Exception {

		User user1 = new User("donalredd@gmail.com1", "donal Redd", "fdsa");
		userRepository.save(user1);
		Long id = user1.getId();
		userRepository.delete(user1);

		assertTrue(null == userRepository.findOne(id));

	}

	@Test
	public void findByEmail() throws Exception {
		for (int i = 0; i < 50; i++) {
			String email = RandomStringUtils.randomAlphabetic(10);
			User user1 = new User("donalredd@gmail.com" + email, "donal Redd",
					"fdsa");
			userRepository.save(user1);
		}

		List<User> findByName = userRepository.findByName("donal Redd");

	}

	@Test
	public void usersByPagination() throws Exception {
		userRepository.deleteAll();
		for (int i = 0; i < 50; i++) {
			String email = RandomStringUtils.randomAlphabetic(10);
			User user1 = new User("donalredd@gmail.com" + email, "donal Redd",
					"fdsa");
			userRepository.save(user1);
		}

		for (int i = 0; i < 5; i++) {
			Page<User> page = userRepository.findAll(new PageRequest(i, 10));
			List<User> content = page.getContent();
			printUser(content);
			long totalElements = page.getTotalElements();
			assertEquals("totalElements should be ", 50, totalElements, 0);
			assertEquals("content should be ", 10, content.size(), 0);
			assertNotNull("page is null", page);
			assertEquals("page number is incorrect", i, page.getNumber(), 0);
			assertEquals("page number of elements is incorrect", 10,
					page.getNumberOfElements(), 0);
			assertEquals("page total number of elements is incorrect", 50l,
					totalElements, 0);
			assertEquals("page total pages is incorrect", 5,
					page.getTotalPages(), 0);
			assertEquals("page size is incorrect", 10, page.getSize(), 0);
			assertEquals("page list size is incorrect", 10, content.size(), 0);
			assertTrue("page has content is incorrect", page.hasContent());

			if (i == 0) {
				assertTrue("has next is incorrect", page.hasNextPage());
				assertFalse("has previous is incorrect", page.hasPreviousPage());
			} else if (i > 0 && i < 4) {
				assertTrue("has next is incorrect", page.hasNextPage());
				assertTrue("has previous is incorrect", page.hasPreviousPage());
			} else if (i == 4) {
				assertFalse("has next is incorrect", page.hasNextPage());
				assertTrue("has previous is incorrect", page.hasPreviousPage());
			}
		}

	}

	private void printUser(Iterable<User> findAll2) {
		for (User user : findAll2) {
			System.out.print(user.getId());
			System.out.print(" ");
			System.out.println(user.getEmail());
		}
	}
}
