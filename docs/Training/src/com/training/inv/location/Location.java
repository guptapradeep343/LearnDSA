package com.training.inv.location;

import java.util.TreeSet;

import com.training.inv.stockledger.ItemStockDetail;
import com.training.inv.stockledger.StockLedger;

public abstract class Location {
	protected String id;
	protected String name;
	protected StockLedger stockLedger;

	public Location(String id, String name, TreeSet<ItemStockDetail> items) {
		this.id = id;
		this.name = name;
		this.stockLedger = new StockLedger(items);
	}

}
