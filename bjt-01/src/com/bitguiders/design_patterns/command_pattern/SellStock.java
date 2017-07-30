package com.bitguiders.design_patterns.command_pattern;

public class SellStock implements Order {
	private Stock stock;
	
	public SellStock(Stock stock){
		this.stock=stock;
	}
	@Override
	public void execute() {
		stock.sell();
	}
	
}
