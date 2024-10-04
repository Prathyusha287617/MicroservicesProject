package com.customer.CustomerService.service;

import java.util.*;

import com.customer.CustomerService.dao.CustomerRepository;
import com.customer.CustomerService.entity.CustomerEntity;
import com.customer.CustomerService.model.CustomerPojo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository custRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepository custRepo){
        this.custRepo=custRepo;
    }

    @Override
    public List<CustomerPojo> getAllDepartments() {
        // TODO Auto-generated method stub
        List<CustomerEntity> allCustEntity = custRepo.findAll();
        List<CustomerPojo> allCustPojo = new ArrayList<>();
        allCustEntity.stream().forEach((eachCustEntity) -> {
            CustomerPojo deptPojo =new CustomerPojo();
            BeanUtils.copyProperties(eachCustEntity, deptPojo);
            allCustPojo.add(deptPojo);
        });
        return allCustPojo;
    }

    @Override
    public CustomerPojo getADepartment(long custId) {
        // TODO Auto-generated method stub
        Optional<CustomerEntity> fetchedCustEntity = custRepo.findById(custId);
        CustomerPojo custPojo = null;
        if(fetchedCustEntity.isPresent()){
            custPojo= new CustomerPojo();
            BeanUtils.copyProperties(fetchedCustEntity.get(), custPojo);
        }
        return custPojo;
    }

    @Override
    public CustomerPojo addDepartment(CustomerPojo newCustPojo) {
        // TODO Auto-generated method stub
        CustomerEntity custEntity = new CustomerEntity();
        BeanUtils.copyProperties(newCustPojo, custEntity);
        custRepo.saveAndFlush(custEntity);
        return newCustPojo;
    }

    /*
    @Override
    public com.example.demo.model.CustomerPojo updateDepartment(com.example.demo.model.CustomerPojo editDeptPojo) {
        // TODO Auto-generated method stub
        com.example.demo.entity.CustomerEntity deptEntity=new com.example.demo.entity.CustomerEntity();
        BeanUtils.copyProperties(editDeptPojo, deptEntity);
        deptRepo.saveAndFlush(deptEntity);
        return editDeptPojo;
    }

    @Override
    public void deleteDepartment(long deptId) {
        // TODO Auto-generated method stub
        deptRepo.deleteById(deptId);
    }
    */

    
}
