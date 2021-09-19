//package com.app.pojos;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
//@ToString
//
//@Entity
//@Table(name= "paymentinfo")
//public class paymentinfo {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column
//	private int payid;
//	@Column(length = 16 )
//	private String cardno;
//	@Column(length = 4 )
//	private String expryyear;
//	@Column(length = 2 )
//	private String exprymonth;
//	@Column(length = 3 )
//	private String cvvnumber; //number
//	@ManyToMany
//	@JoinColumn(name= "userid")
//	private int userid;
//
//}


