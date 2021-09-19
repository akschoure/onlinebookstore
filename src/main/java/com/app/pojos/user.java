package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
@Column (length = 30)
private String firstname;
@Column (length = 30)
private String lastname;
@Column (length = 30)
private String emailid;
@Column (length = 10)
private String mobilenumber;
@Column (length = 10)         //10
private String password;
@Column (length = 6)
private String gender;


}
