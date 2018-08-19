package com.training.inv.stockledger;

import com.training.inv.item.Item;

public class ItemStockDetail implements Comparable<ItemStockDetail>{
	private Item item;

	private Integer itemAtHand;
	private Integer reOrderThresold;

	public ItemStockDetail(Item item, Integer itemAtHand, Integer reOrderThresold) {
		this.item = item;
		this.itemAtHand = itemAtHand;
		this.reOrderThresold = reOrderThresold;
	}

	public Integer getItemAtHand() {
		return itemAtHand;
	}
	public Integer getReOrderThresold() {
		return reOrderThresold;
	}

	public Item getItem() {
		return item;
	}
	@Override
	public int compareTo(ItemStockDetail o) {
		return this.itemAtHand.compareTo(o.itemAtHand);
	}
}
