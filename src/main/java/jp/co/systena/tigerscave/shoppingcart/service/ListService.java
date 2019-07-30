package jp.co.systena.tigerscave.shoppingcart.service;

import java.util.ArrayList;
import java.util.List;

import jp.co.systena.tigerscave.shoppingcart.model.Item;

public class ListService {

	public List<Item> getItemList(){


		List<Item> itemList = new ArrayList<Item>();

		Item item = new Item();
		item.setItemid(10);
		item.setName("じゃがりこ");
		item.setPrice(350);

		itemList.add(item);

		return itemList;
	}
}
