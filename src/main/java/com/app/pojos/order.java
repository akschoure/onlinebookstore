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
//
//@Entity
//@Table(name = "order")
//public class order {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column
//	private int id;
//	@Column
//	private int orderid;
//	@Column
//	private int qty;    //int
//	@ManyToOne
//	@JoinColumn(name="userid")
//	private int userid;
//	@ManyToMany
//	@JoinColumn(name="bookid")
//	private int bookid;
//	
//	
//}
