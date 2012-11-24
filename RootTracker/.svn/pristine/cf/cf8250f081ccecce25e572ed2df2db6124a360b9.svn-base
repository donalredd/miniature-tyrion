package com.receipt.vault.service;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.receipt.vault.dao.UserRepository;
import com.receipt.vault.model.User;

@RunWith(JMock.class)
@Ignore
public class UserServiceTest {

    Mockery context = new Mockery();

    private UserRepository userRepository = context.mock(UserRepository.class);

    UserServiceImpl userService = new UserServiceImpl();

    @Test
    public void testCreateUser() {
	final User user = new User("email", "name", "password");
	context.checking(new Expectations() {
	    {
		oneOf(userRepository).save(user);
	    }
	});

	userService.setUserRepository(userRepository);

	userService.createUser(user);

    }

    @Test
    public void testFindUser() {
	final User user = new User("email", "name", "password");
	final Long ID = Long.valueOf("1");
	context.checking(new Expectations() {
	    {
		oneOf(userRepository).findById(ID);
		will(returnValue(user));
	    }
	});

	userService.setUserRepository(userRepository);

	userService.findById(ID);

    }
}
