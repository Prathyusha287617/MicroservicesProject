package com.order.OrderService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="order_details")
public class OrderEntity {
    @Id
    @Column(name="ord_id")
    private long ordId;

    @Column(name="ord_name")
    private String ordName;

    @Column(name="cust_id")
    private long custId;

}
