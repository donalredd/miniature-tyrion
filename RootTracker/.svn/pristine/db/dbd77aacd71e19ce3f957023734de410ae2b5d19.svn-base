package com.receipt.vault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.receipt.vault.dao.StoreRepository;
import com.receipt.vault.model.Store;

@Service
public class StoreServiceImpl implements StoreService {
	
	 
	StoreRepository storeRepository;
	
	@Autowired
	public void setStoreRepository(StoreRepository storeRepository) {
		this.storeRepository = storeRepository;
	}

	public Store findById(Long id) {
		return storeRepository.findById(id);
	}

	public Store saveStore(Store store) {
		return storeRepository.save(store);
	}

	public void deleteItem(Long id) {
		 storeRepository.delete(id);
		
	}

	public Iterable<Store> findAll() {
		return storeRepository.findAll();
	}

}
