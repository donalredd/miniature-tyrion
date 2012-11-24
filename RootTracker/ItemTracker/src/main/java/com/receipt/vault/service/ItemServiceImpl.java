package com.receipt.vault.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.receipt.vault.dao.ItemRepository;
import com.receipt.vault.model.Item;

@Service
@Transactional(readOnly = true)
@Path("/vault/itemservice/")
public class ItemServiceImpl implements ItemService {

	private ItemRepository itemRepository;

	@Autowired
	public void setItemRepository(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@GET
	@Path("/item/{id}")
	@Produces("application/xml")
	public Item findById(@PathParam("id") Long id) {
		return itemRepository.findById(id);
	}

	@POST
	@Path("/item/{id}")
	@Produces("application/xml")
	public Item saveItem(@PathParam("item") Item item) {
		return itemRepository.save(item);
	}

	public void deleteItem(Long id) {
		itemRepository.delete(id);
	}

	public Iterable<Item> findAll() {
		return itemRepository.findAll();
	}
}
