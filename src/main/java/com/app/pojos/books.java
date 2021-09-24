package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table (name = "books")
public class Books {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer bookid;

	@Column (length = 30 )
	private String title;
	
	@Column (length=50)
	private String publication;

	@Column (length = 30 , unique = true)
	private String isbn;
	
	@Column
	private double price ;
	
	@Column (length = 2000)
	private String description;
	
	@Column 
	private int quantity;      //int 

	@Column (length = 500)
	private String imageurl;
	
	@Column
	private double discount;

	@Column
	private LocalDate arrivaldate;

	@Column (length = 10)
	private String language;

	@Column (length = 6)
	private int pages;                 //int 


	//@ManyToOne
	//@JoinColumn (name= "categoryid")
	//private Category category;
	@Column  (name= "categoryid")
	private Integer categoryId;

	//@ManyToOne
	//@JoinColumn (name= "authorId")
	@Column  (name= "authorid")
	private Integer authorId;
	
}