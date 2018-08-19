package com.training.inv.stockledger;

public class Painter {
	Shape s;
	void paint(Shape s, int x, int y){
		System.out.println("painted area is: "+s.calculateArea(x, y));
	}
}
