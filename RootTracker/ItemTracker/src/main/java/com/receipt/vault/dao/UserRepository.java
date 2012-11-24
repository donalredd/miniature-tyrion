package com.receipt.vault.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.receipt.vault.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>,
	JpaSpecificationExecutor<User> {

    User findById(Long id);

    List<User> findByName(String email);
}
