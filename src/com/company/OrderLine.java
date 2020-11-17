package com.company;

public class OrderLine {
    public int getPizzaNo() {
        return pizzaNo;
    }

    public OrderLine(int pizzaNo, int amount) {
        this.pizzaNo = pizzaNo;
        this.amount = amount;
    }

    public void setPizzaNo(int pizzaNo) {
        this.pizzaNo = pizzaNo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    int pizzaNo;
    private int amount;
}
