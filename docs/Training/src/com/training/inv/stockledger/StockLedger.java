package com.training.inv.stockledger;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StockLedger {
	private TreeSet<ItemStockDetail> itemSet;

	public StockLedger(TreeSet<ItemStockDetail> items) {
		this.itemSet = items;
	}

	public TreeSet<ItemStockDetail> getItemSet() {
		return itemSet;
	}

	public ItemStockDetail getTopStockItem() {
		return this.getItemSet().last();
	}

	public List<ItemStockDetail> getreOrderItems() {
		List<ItemStockDetail> list = null;
		itemSet.stream().parallel().filter(i->i.getReOrderThresold() >= i.getItemAtHand()).collect(Collectors.toList());
		itemSet.stream().collect(Collectors.groupingBy(itemStockDetail->itemStockDetail.getItem().getName()));
		itemSet.stream().parallel().forEach(item->item.getItem().getWeight());
		itemSet.stream().parallel().collect(Collectors.summingDouble(item->item.getItem().getWeight()));
		itemSet.stream().parallel().max((i1, i2)->i1.getItemAtHand().compareTo(i2.getItemAtHand()));
		if (this.itemSet.size() > 0) {
			list = new ArrayList<>();
			for (ItemStockDetail i : this.itemSet) {
				if (i.getReOrderThresold() >= i.getItemAtHand()) {
					list.add(i);
				}
			}
			return list;
		}
		return null;
	}
}
