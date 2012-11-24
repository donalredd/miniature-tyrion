package com.receipt.vault.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.receipt.vault.model.Item;
import com.receipt.vault.model.User;

public interface ItemRepository extends CrudRepository<Item, Long>,
	JpaSpecificationExecutor<User> {

    Item findById(Long id);

    Item save(Item item);
}
