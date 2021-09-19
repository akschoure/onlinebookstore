//package com.app.pojos;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
//@ToString
//
//@Entity
//@Table(name= "wishlist")
//public class wishlist {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column
//	private int wishlistid;
//	@OneToMany
//	@JoinColumn(name = "bookid")
//	private int bookid;
//	@OneToOne
//	@JoinColumn(name = "userid")
//	private int userid;
//	
//
//}
