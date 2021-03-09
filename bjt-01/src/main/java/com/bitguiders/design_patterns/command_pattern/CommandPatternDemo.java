package com.bitguiders.design_patterns.command_pattern;

public class CommandPatternDemo {

	public static void main(String[] args) {

		Stock stock = new Stock();
		
		BuyStock  buy = new BuyStock(stock);
		SellStock sell= new SellStock(stock);
		
		Broker broker = new Broker();
		
		broker.takeOrder(buy);
		broker.takeOrder(sell);
		
		broker.placeOrders();
	}

}
