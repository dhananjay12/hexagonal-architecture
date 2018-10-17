package com.mynotes.example;


public class HappyBirthdayApplication {

	public static void main(String[] args) {
		BirthdayService employeeService=new BirthdayService("employees.csv");
		employeeService.sendCoupons();
	}
}
