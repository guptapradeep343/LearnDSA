package com.training.inv.item;

public class Item {
	private String name;
	private Double weight;
	private String id;

	public Item(String name, Double weight,String id) {
		this.name = name;
		this.weight = weight;
		this.id = id;
	}
	@SystemTableEntryKey
	public String getId() {
		return id;
	}
	@SystemTableEntryKey
	public String getName() {
		return name;
	}
	@SystemTableEntryKey
	public Double getWeight() {
		return weight;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}

}
