package com.customer.CustomerService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderPojo {
    private long ordId;

    private String ordName;

    private long custId;
}
