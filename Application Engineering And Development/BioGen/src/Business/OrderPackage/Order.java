/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.OrderPackage;

import Business.*;
import java.util.ArrayList;

/**
 *
 * @author Atul
 */
public class Order {
    private String orderID;
    private ArrayList<OrderItem> orderItemList;
    private static int c = 000;
    
    public Order() {
        ++c;
        orderID = "OID"+c;
        orderItemList = new ArrayList<OrderItem>();
    }

    public static int getC() {
        return c;
    }

    public static void setC(int c) {
        Order.c = c;
    }

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderID() {
        return orderID;
    }
    
    public OrderItem newOrderItem()
    {
        OrderItem orderItem = new OrderItem();
        orderItemList.add(orderItem);
        return orderItem;
    }
    
    public void removeOrderItem(OrderItem o)
    {
        orderItemList.remove(o);
    }
    
}
