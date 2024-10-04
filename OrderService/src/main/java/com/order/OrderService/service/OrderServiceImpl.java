package com.order.OrderService.service;


import com.order.OrderService.dao.OrderRepository;
import com.order.OrderService.entity.OrderEntity;
import com.order.OrderService.model.OrderPojo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository ordRepo;



    @Autowired
    public OrderServiceImpl(OrderRepository empRepo){
        this.ordRepo=ordRepo;
    }


    @Override
    public List<OrderPojo> getAllOrderByCustomer(long deptId) {
        List<OrderEntity> getOrdEntity=ordRepo.findByCustId(deptId);
        List<OrderPojo> allOrdPojo=new ArrayList<>();
        getOrdEntity.stream().forEach((eachEmpEntity) -> {
            OrderPojo empPojo =new OrderPojo();
            BeanUtils.copyProperties(eachEmpEntity, empPojo);
            allOrdPojo.add(empPojo);
        });
        return allOrdPojo;
    }

    @Override
    public List<OrderPojo> getAllOrders() {
        List<OrderEntity> allEmpEntity = ordRepo.findAll();
        List<OrderPojo> allEmpPojo = new ArrayList<>();
        allEmpEntity.stream().forEach((eachEmpEntity) -> {
            OrderPojo empPojo =new OrderPojo();
            BeanUtils.copyProperties(eachEmpEntity, empPojo);
            allEmpPojo.add(empPojo);
        });
        return allEmpPojo;
    }

    @Override
    public OrderPojo getAOrder(Long ordId) {
        Optional<OrderEntity> fetchedEmpEntity =ordRepo.findById(ordId);
        OrderPojo empPojo = null;
        if(fetchedEmpEntity.isPresent()){
            empPojo= new OrderPojo();
            BeanUtils.copyProperties(fetchedEmpEntity.get(), empPojo);
        }
        return empPojo;
    }

    @Override
    public OrderPojo addOrder(OrderPojo newEmpPojo) {
        OrderEntity empEntity = new OrderEntity();
        BeanUtils.copyProperties(newEmpPojo, empEntity);
        ordRepo.saveAndFlush(empEntity);
        return newEmpPojo;
    }
    /*
    @Override
    public com.employee.EmployeeService.model.OrderPojo updateEmployee(com.employee.EmployeeService.model.OrderPojo editEmpPojo) {
        com.employee.EmployeeService.entity.OrderEntity empEntity=new com.employee.EmployeeService.entity.OrderEntity();
        BeanUtils.copyProperties(editEmpPojo, empEntity);
        empRepo.saveAndFlush(empEntity);
        return editEmpPojo;
    }

    @Override
    public void deleteEmployee(long empId) {
        empRepo.deleteById(empId);
    }

     */
}
