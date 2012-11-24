package com.receipt.vault.integration;

import static junit.framework.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.receipt.vault.dao.StoreRepository;
import com.receipt.vault.model.Store;

@Ignore
@ContextConfiguration("classpath:spring-beans.xml")
public class StoreRepositoryTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private StoreRepository storeRepository;

	@Test
	public void saveStore() throws Exception {

		Store store = new Store("John Lewis", "NA", "", "", "555-12336", "");
		storeRepository.save(store);
		assertTrue(store.getId() != null);
		System.out.println(store.getId());

	}

	@Test
	public void findsAllStore() throws Exception {

		Store store1 = new Store("John Lewis", "NA", "", "", "555-12336", "");
		storeRepository.save(store1);
		Store Store2 = new Store("Gadget", "NA", "", "", "555-12336", "");
		storeRepository.save(Store2);
		assertTrue(storeRepository.count() == 2);
	}

	@Test
	public void removeStore() throws Exception {

		Store store1 = new Store("John Lewis", "NA", "", "", "555-12336", "");
		storeRepository.save(store1);
		Long id = store1.getId();
		storeRepository.delete(store1);
		assertTrue(null == storeRepository.findOne(id));

	}

}
