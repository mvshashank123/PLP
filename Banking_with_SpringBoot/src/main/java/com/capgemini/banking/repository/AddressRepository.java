package com.capgemini.banking.repository;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.banking.bean.Address;

public interface AddressRepository extends CrudRepository<Address, Integer>{

}
