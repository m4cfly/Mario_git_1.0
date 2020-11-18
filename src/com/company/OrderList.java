package com.company;

import java.util.ArrayList;
import java.util.List;

public class OrderList {

    private List<Order> orderList;

    public OrderList() {
        this.orderList = new ArrayList<Order>();
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void addOrder(Order order){
        orderList.add(order);
    }

    public int getTotalNumberOfOrders(){
        return orderList.size();
    }
    public void showOrders() {
        for (Order order : orderList) {
            System.out.println(order.getPizzaNo() + ", " +
                    order.getAmount() + ", " +
                    //order.getPrice() + ", " +
                    Input.getMinutesToTimeFormat(order.getPickupTime()) + ", " +
                    order.getOrderTime() + ", " +
                    order.getCustomerName() + ", "
                   // order.getPhoneNo() + ", " +
                    // order.getStatus()
            );
        }
    }
}
