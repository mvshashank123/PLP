package com.capgemini.banking.repository;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.banking.bean.BankTransaction;

public interface BankTransactionRepository extends CrudRepository<BankTransaction, Integer>{

}
