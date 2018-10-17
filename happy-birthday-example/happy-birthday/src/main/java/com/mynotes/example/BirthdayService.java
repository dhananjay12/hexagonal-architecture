package com.mynotes.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BirthdayService {
	String filePath;
	public BirthdayService(String filePath) {
		this.filePath = filePath;
	}

	public void sendCoupons() {
		LocalDate today = LocalDate.now();
		List<Employee> employees = getEmployees();
		employees.stream().filter(emp -> emp.getDob().getMonth().equals(today.getMonth()))
				.forEach(System.out::println);
	}

	private List<Employee> getEmployees() {

		List<Employee> employees = new ArrayList<Employee>();

		try (BufferedReader in = new BufferedReader(new FileReader(filePath))) {
			String line = in.readLine(); // skip header
			while ((line = in.readLine()) != null) {
				Employee employee = mapEmployee(line);
				employees.add(employee);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return employees;
	}

	private Employee mapEmployee(String line) {
		String[] data = line.split(",");
		return new Employee(Integer.parseInt(data[0]), data[1],
				LocalDate.parse(data[2], DateTimeFormatter.ofPattern("dd-MM-yyyy")));
	}

}
