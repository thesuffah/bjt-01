package com.bitguiders.design_patterns.command_pattern;

import java.util.ArrayList;
import java.util.List;

public class Broker {
    public List<Order> orderList = new ArrayList<Order>();
    
    public void takeOrder(Order order){
    	orderList.add(order);
    };
    public void placeOrders(){
    	orderList.forEach(o->o.execute());
    	orderList.clear();
    };
}
