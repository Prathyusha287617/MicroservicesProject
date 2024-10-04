package com.customer.CustomerService.controller;

import java.util.List;

import com.customer.CustomerService.model.CustomerPojo;
import com.customer.CustomerService.model.OrderPojo;
import com.customer.CustomerService.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/demo")
public class CustomerController {
    @Autowired
    private CustomerService deptService;

    public static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    @GetMapping("/customers")
    public List<CustomerPojo> getAllDepartments(){
        LOG.info("in getAllCustomers");
        List<CustomerPojo> cust=deptService.getAllDepartments();
        return cust;
    }

    @GetMapping("/customers/{did}")
    public CustomerPojo getADepartment(@PathVariable("did") long custId){
        //return deptService.getADepartment(deptId);
        LOG.info("in getACustomer");
        CustomerPojo custPojo = deptService.getADepartment(custId);
        RestClient restClient = RestClient.create();
        List<OrderPojo> allEmps = restClient.get().uri("http://localhost:8090/demo/orders/customers/" + custId)
                .retrieve()
                .body(List.class);
        custPojo.setAllOrders(allEmps);
        return custPojo;
    }

    @PostMapping("/departments")
    public CustomerPojo addDepartment(@RequestBody CustomerPojo newCust){
        LOG.info("in addCustomers");
        return deptService.addDepartment(newCust);
    }
    /*
    @PutMapping("/departments")
    public com.example.demo.model.CustomerPojo updateDepartment(@RequestBody com.example.demo.model.CustomerPojo newDept){
        LOG.info("in updateDepartments");
        return deptService.updateDepartment(newDept);
    }

    @DeleteMapping("/departments/{did}")
    public void removeDepartment(@PathVariable("did") long deptId){
        LOG.info("in removeDepartments");
        deptService.deleteDepartment(deptId);
    }
    */

}
