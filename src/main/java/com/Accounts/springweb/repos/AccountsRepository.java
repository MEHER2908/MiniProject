package com.Accounts.springweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Accounts.springweb.entities.Account;

public interface AccountsRepository extends JpaRepository<Account,Integer> {
			
}
