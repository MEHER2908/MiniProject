package com.Accounts.springweb.controllers;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Accounts.springweb.entities.Account;
import com.Accounts.springweb.repos.AccountsRepository;

@Controller
@RestController
public class AccountControllers {
	
	@Autowired
	AccountsRepository Repository;
	Account session;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public List<Account>acts(){
		return Repository.findAll();
	}
	
	@GetMapping("/Accountform")
	public ModelAndView dispalyAccountForm() {
		ModelAndView mav= new ModelAndView("Accountform");
		Account account= new Account();
		mav.addObject("Account",account);
		//System.out.print("Account form generated");
		return mav;
	}
	
	@PostMapping("/Accountform")
	public ModelAndView saveform(@ModelAttribute Account account) {
		System.out.print("Account form recieved");
		Repository.save(account);
		session=account;
		return home();
	}
	
	
	@RequestMapping("/Home")
	public ModelAndView home() {
		ModelAndView mav= new ModelAndView("Home");
		return mav;
	}
	
	@RequestMapping("/Invalid")
	public ModelAndView Invalid() {
		ModelAndView mav= new ModelAndView("Invalid");
		return mav;
	}
	
	
	@RequestMapping("/Failed")
	public ModelAndView Failed() {
		ModelAndView mav= new ModelAndView("Failed");
		return mav;
	}
	
	
	@GetMapping("/Login")
	public ModelAndView loginpage() {
		ModelAndView mav= new ModelAndView("Login");
		Account account= new Account();
		account.setuserName("");
		account.setPassword("");
		mav.addObject("Account",account);
		return mav;
	}
	
	@PostMapping("/Login")
	public ModelAndView authnetication(@ModelAttribute Account account) {
		//System.out.print(account.getuserName());
		ModelAndView mav;
		Account temp= Repository.findByuserName(account.getuserName());
		//System.out.print(account.getuserName()+"from form");
		//Repository.findByUser_name(account.getUser_name());
		if(temp!=null && temp.getPassword().equals(account.getPassword())){
			session=temp;
			mav= new ModelAndView("Home");
		}
		else {
			mav = new ModelAndView("Invalid");
		}
		return mav;
	}
	
	@GetMapping("/Details")
	public ModelAndView userdetails() {
		ModelAndView mav= new ModelAndView("Details");
		System.out.print(session.getAcc_ID());
		mav.addObject("Account",session);
		return mav;
	}
	
	@GetMapping("/Balance")
	public ModelAndView userbalance() {
		ModelAndView mav= new ModelAndView("Balance");
		mav.addObject("Balance",session.getAcc_balance());
		return mav;
	}
	
	
	@GetMapping("/Withdraw")
	public ModelAndView withdraw() {
		ModelAndView mav= new ModelAndView("Withdraw");
		Account account= new Account();
		mav.addObject("Account",account);
		return mav;
	}
	
	@PostMapping("/Withdraw")
	public ModelAndView possiblewithdraw(@ModelAttribute Account account) {
		int temp = (int) session.getAcc_balance()- account.getAmount();
		if(temp>=0) {
			session.setAcc_balance(temp);
			Repository.save(session);
			return userbalance();
		}
		else {
			return Failed();
		}
	}
	
	@GetMapping("/Deposit")
	public ModelAndView deposit() {
		ModelAndView mav= new ModelAndView("Deposit");
		Account account= new Account();
		mav.addObject("Account",account);
		return mav;
	}
	
	@PostMapping("/Deposit")
	public ModelAndView possibledeposit(@ModelAttribute Account account) {
		//System.out.print(account.getAmount()+"from form");
		if(account.getAmount()>0) {
			session.setAcc_balance(session.getAcc_balance()+account.getAmount());
			Repository.save(session);
			return userbalance();
		}
		else {
			return Failed();
		}
	}
}



