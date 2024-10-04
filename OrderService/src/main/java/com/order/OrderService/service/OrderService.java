package com.order.OrderService.service;



import com.order.OrderService.model.OrderPojo;

import java.util.List;

public interface OrderService {
    List<OrderPojo> getAllOrders();
    OrderPojo getAOrder(Long ordId);
    OrderPojo addOrder(OrderPojo newOrdPojo);
    //com.employee.EmployeeService.model.OrderPojo updateEmployee(com.employee.EmployeeService.model.OrderPojo editEmpPojo);
    //void deleteEmployee(long empId);
    List<OrderPojo> getAllOrderByCustomer(long ordId);
}
