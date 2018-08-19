package com.training.inv.item;

public class SubItem {
	private String name;
	private Double weight;
	private String id;

	public SubItem(String name, Double weight,String id) {
		this.name = name;
		this.weight = weight;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

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
