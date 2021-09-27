package com.app.pojos;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name ="user")
public class User {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
    @Column
	private int userid;	
    @Column (length = 30)
    private String firstname;
    @Column (length = 30)
    private String lastname;
    @Column (length = 30)
    private String emailid;
    @Column (length = 10)
    private String mobilenumber;
    @Column (length = 10)         
    private String password;
    @Column (length = 6)
    private String gender;


}
