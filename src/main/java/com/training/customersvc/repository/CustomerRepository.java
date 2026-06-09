package com.training.customersvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.customersvc.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
