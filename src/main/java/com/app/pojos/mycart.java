package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name= "mycart")

public class Mycart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int cartid;
	@Column
	private int quantity;    //int 
	
	
	//@OneToMany
	//@JoinColumn(name = "bookid")
	//private Books books;
    @Column  (name= "bookid")
	private Integer bookId;
	
	
	

	
	
	//@OneToOne
	//@JoinColumn(name = "userid")
	//private User userid;
	@Column  (name= "userid")
	private Integer userId;
	
		

}
