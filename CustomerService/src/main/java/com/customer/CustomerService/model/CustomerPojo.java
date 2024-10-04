package com.customer.CustomerService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerPojo {
    
    private long custId;
    private String custName;
    private List<OrderPojo> allOrders;

    public List<OrderPojo> getAllOrders() {
        return allOrders;
    }

    public void setAllOrders(List<OrderPojo> allEmployees) {
        this.allOrders = allEmployees;
    }
}
