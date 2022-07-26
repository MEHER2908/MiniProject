package com.Accounts.springweb.controllers;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Accounts.springweb.entities.Account;
import com.Accounts.springweb.repos.AccountsRepository;


@RestController
public class AccountControllers {
	
	@Autowired
	AccountsRepository Repository;
	
	@RequestMapping("/Accountform")
	public ModelAndView dispalyAccountForm() {
		ModelAndView mav= new ModelAndView("Accountform");
		Account account= new Account();
		mav.addObject("Account",account);
		return mav;
	}
	
	
}


