package com.customer.CustomerService.service;

import com.customer.CustomerService.model.CustomerPojo;

import java.util.List;

public interface CustomerService {
    List<CustomerPojo> getAllDepartments();
    CustomerPojo getADepartment(long deptId);
    CustomerPojo addDepartment(CustomerPojo newDeptPojo);
    //CustomerPojo updateDepartment(CustomerPojo editDeptPojo);
    //void deleteDepartment(long deptId);
}
