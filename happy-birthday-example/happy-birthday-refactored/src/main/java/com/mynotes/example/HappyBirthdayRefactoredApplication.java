package com.mynotes.example;

import com.mynotes.example.adaptors.FileEmployeeStore;
import com.mynotes.example.core.BirthdayService;
import com.mynotes.example.core.EmployeeStore;

public class HappyBirthdayRefactoredApplication {

	public static void main(String[] args) {
		EmployeeStore store=new FileEmployeeStore("employees.csv");
		BirthdayService service=new BirthdayService(store);
		service.sendCoupons();
		
	}
}
