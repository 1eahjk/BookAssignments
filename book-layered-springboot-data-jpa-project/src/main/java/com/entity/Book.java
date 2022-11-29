package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Book")
public class Book implements Serializable {

	@Id
	@Column(name = "bookId")
	private int bookId;
	
	@Column(name="bookName")
	private String bookName;
	
	@Column(name="authorName")
	private String authorName;
	
	@Column(name="noOfCopies")
	private double noOfCopies;
	
}
