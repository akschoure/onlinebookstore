package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int reviewid;
	@Column 
	private int rating;
	@Column (length= 2000)
	private String review;
	@Column
	private LocalDate reviewdate;
	@OneToOne
	@JoinColumn(name = "userid")
	private User user;
	@OneToOne
	@JoinColumn(name= "bookid")
	private Books books;
	


}
