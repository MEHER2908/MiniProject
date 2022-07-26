package com.Accounts.springweb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int Acc_ID;
      private String Holder_name;
      private String User_name;
      private int Password;
      private int Phone_no;
      private double Acc_balance;
	public int getAcc_ID() {
		return Acc_ID;
	}
	public void setAcc_ID(int acc_ID) {
		Acc_ID = acc_ID;
	}
	public String getHolder_name() {
		return Holder_name;
	}
	public void setHolder_name(String holder_name) {
		Holder_name = holder_name;
	}
	public String getUser_name() {
		return User_name;
	}
	public void setUser_name(String user_name) {
		User_name = user_name;
	}
	public int getPassword() {
		return Password;
	}
	public void setPassword(int password) {
		Password = password;
	}
	public int getPhone_no() {
		return Phone_no;
	}
	public void setPhone_no(int phone_no) {
		Phone_no = phone_no;
	}
	public double getAcc_balance() {
		return Acc_balance;
	}
	public void setAcc_balance(double acc_balance) {
		Acc_balance = acc_balance;
	}
}
