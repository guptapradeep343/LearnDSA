package com.training.inv.stockledger;

public class PaintTest {
	public static void main(String[] args) {
		Painter p  = new Painter();
		Shape s1 = (x,y)-> x*y;
		p.paint((x,y)-> x*y,2,3);
		p.paint(PaintTest::calculateArea, 2, 3);
	}
	public static int calculateArea(int x, int y){
		return x*y;
	}
}
