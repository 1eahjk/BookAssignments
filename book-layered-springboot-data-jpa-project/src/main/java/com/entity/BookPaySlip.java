package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookPaySlip {

	private Book book;
	private double allowanceA;
	private double allowanceB;
	private double deduction;
	private double totalSalary;
	
}
