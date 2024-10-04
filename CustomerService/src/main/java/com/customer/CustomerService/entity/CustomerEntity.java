package com.customer.CustomerService.entity;

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
@Table(name="customer_details")
public class CustomerEntity {
    @Id
    @Column(name="cust_id")
    private long custId;

    @Column(name="cust_name")
    private String custName;
}