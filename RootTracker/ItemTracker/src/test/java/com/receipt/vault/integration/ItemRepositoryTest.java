package com.receipt.vault.integration;

import static junit.framework.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.receipt.vault.dao.ItemRepository;
import com.receipt.vault.model.Category;
import com.receipt.vault.model.ImageInfo;
import com.receipt.vault.model.Item;
import com.receipt.vault.model.Store;

@Ignore
@ContextConfiguration("classpath:spring-beans.xml")
public class ItemRepositoryTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ItemRepository itemRepository;

	@Test
	public void saveItem() {

		Store store = new Store("John Lewis", "", "", "", "", "");
		Category category = new Category("Kitchen");
		ImageInfo imageInfo = new ImageInfo("fdsafdsa");
		Item item = new Item("Laoptop", "Asus", store, category, "tags");
		item.addImageInfo(imageInfo);
		itemRepository.save(item);
		assertTrue(item.getId() != null);
		assertTrue(1 == item.getImages().size());

	}

}
