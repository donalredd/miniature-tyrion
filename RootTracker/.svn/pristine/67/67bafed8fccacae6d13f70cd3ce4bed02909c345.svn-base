package com.receipt.vault.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.receipt.vault.model.Store;
import com.receipt.vault.model.User;

public interface StoreRepository extends CrudRepository<Store, Long>,
	JpaSpecificationExecutor<User> {

    Store findById(Long id);
}
