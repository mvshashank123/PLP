package com.capgemini.banking.repository;


import org.springframework.data.repository.CrudRepository;

import com.capgemini.banking.bean.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Integer>{



}
