package com.receipt.vault.service;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.receipt.vault.dao.ItemRepository;
import com.receipt.vault.model.Category;
import com.receipt.vault.model.ImageInfo;
import com.receipt.vault.model.Item;
import com.receipt.vault.model.Store;

@RunWith(JMock.class)
public class ItemServiceTest {

	Mockery context = new Mockery();

	private ItemRepository itemRepository = context.mock(ItemRepository.class);

	ItemServiceImpl itemService = new ItemServiceImpl();

	@Test
	public void testSave() {
		Store store = new Store("fda", "sales", "address", "map", "phone",
				"Notes");
		final Item item = new Item("Name", "description", store, new Category(
				"name"),  "tag");
		context.checking(new Expectations() {
			{
				oneOf(itemRepository).save(item);
			}
		});

		itemService.setItemRepository(itemRepository);

		itemService.saveItem(item);

	}

	@Test
	public void testRemoval() {

		final Long id = new Long(1);

		context.checking(new Expectations() {
			{
				oneOf(itemRepository).delete(id);
			}
		});
		itemService.setItemRepository(itemRepository);
		itemService.deleteItem(id);

	}

}
