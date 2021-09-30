package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private int orderid;
	@Column
	private int quantity;    //int
	
	//@ManyToOne
	//@JoinColumn(name="userid")
	@Column  (name= "userid")
	private Integer userId;
	
	//@ManyToMany
	//@JoinColumn(name="bookid")
	@Column  (name= "bookid")
	private Integer bookId;

	public Order(int orderid, int quantity, Integer userId, Integer bookId) {
		super();
		this.orderid = orderid;
		this.quantity = quantity;
		this.userId = userId;
		this.bookId = bookId;
	}
	
	
	
}
