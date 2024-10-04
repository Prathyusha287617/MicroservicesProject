package com.order.OrderService.controller;

import com.order.OrderService.model.OrderPojo;
import com.order.OrderService.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class OrderController {
    @Autowired
    private OrderService ordService;

    public static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/orders")
    public List<OrderPojo> getAllOrders(){
        LOG.info("in getAllOrders");
        List<OrderPojo> emp=ordService.getAllOrders();
        return emp;
    }

    @GetMapping("/orders/{did}")
    public OrderPojo getAOrder(@PathVariable("did") long ordId){
        LOG.info("in getAOrder");
        return ordService.getAOrder(ordId);
    }

    @GetMapping("/orders/customers/{did}")
    public List<OrderPojo> getAllOrderByCustomer(@PathVariable long did){
        LOG.info("in getAllOrdersByCustomer");
        return ordService.getAllOrderByCustomer(did);
    }

    @PostMapping("/orders")
    public OrderPojo addOrders(@RequestBody OrderPojo newOrd){
        LOG.info("in addOrders");
        return ordService.addOrder(newOrd);
    }

    /*
    @PutMapping("/employees")
    public com.employee.EmployeeService.model.OrderPojo updateEmployee(@RequestBody com.employee.EmployeeService.model.OrderPojo newEmp){
        LOG.info("in updateEmployees");
        return empService.updateEmployee(newEmp);
    }

    @DeleteMapping("/employees/{did}")
    public void removeEmployee(@PathVariable("did") long empId){
        LOG.info("in removeEmployees");
        empService.deleteEmployee(empId);
    }
    */

}
