package com.receipt.vault.service;

import java.io.IOException;
import java.io.InputStream;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.receipt.vault.dao.UserRepository;
import com.receipt.vault.model.User;

@Service
@Transactional(readOnly = true)
@WebService(serviceName = "UserService", endpointInterface = "com.receipt.vault.service.UserService")
@Path("/vault/userservice/")
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GET
	@Path("/person/{id}")
	@Produces("application/json")
	public User findById(@PathParam("id") Long id) {
		User entity = new User("afdasf" + System.currentTimeMillis(),
				"fdsafsa", "");
		userRepository.save(entity);
		User foundUser = userRepository.findById(entity.getId());
		return foundUser;
	}

	public void createUser(User user) {
		userRepository.save(user);
	}

	@POST
	@Path("/upload")
	@Consumes("multipart/form-data")
	public void handle(MultipartBody body) {
		// presumes the part has a content id
		Attachment a = body.getAttachment("file");
		ContentDisposition cd = a.getContentDisposition();
		try {
			InputStream is = a.getDataHandler().getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// proceed
	}

	@GET
	@Path("/person/findAll")
	@Produces("application/json")
	public Iterable<User> findAll() {
		Iterable<User> findAll = userRepository.findAll();

		return findAll;
	}

}
