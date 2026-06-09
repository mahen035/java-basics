package com.training.customersvc.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.customersvc.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
