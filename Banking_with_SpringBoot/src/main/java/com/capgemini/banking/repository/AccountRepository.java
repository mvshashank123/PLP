package com.capgemini.banking.repository;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.banking.bean.Account;

public interface AccountRepository extends CrudRepository<Account ,Long>{

}
