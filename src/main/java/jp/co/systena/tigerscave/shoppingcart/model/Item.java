package jp.co.systena.tigerscave.shoppingcart.model;

public class Item {

	// 商品ID
	private int itemid;

	// 名前
	private String name;

	// 価格
	private int price;


	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getName() {
	    return this.name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
