package com.bitguiders.design_patterns.command_pattern;

public class BuyStock implements Order {
	private Stock stock;
	
	public BuyStock(Stock stock){
		this.stock=stock;
	}
	@Override
	public void execute() {
		stock.buy();
	}

}
