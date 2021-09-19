package com.app.pojos;

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
@Table(name = "author")
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int authorid;
	
	@Column(length = 30)
	private String authorname;
	
	@Column (length = 1000)
	private String description;
	

}
