package com.training.accountsvc.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.accountsvc.entity.Account;

public interface AccountRepository extends JpaRepository<Account, UUID> {

}
