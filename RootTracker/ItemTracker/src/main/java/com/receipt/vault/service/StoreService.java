package com.receipt.vault.service;

import com.receipt.vault.model.Store;

public interface StoreService {

	Store findById(Long id);

	Store saveStore(Store item);

	void deleteItem(Long id);

	Iterable<Store> findAll();

}
