package com.learning.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



import com.learning.Exception.InvalidPasswordException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="reg")
public class Register implements Comparable<Register>{
	
	@Id
	@Column(name="regId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Size(max=50)
	@NotBlank
	@Email
	private String email;
	@Size(max=50)
	@NotBlank
	private String name;
	@Size(max=50)
	@NotBlank
	private String password;
	@Size(max=100)
	@NotBlank
	private String address;
	
	
	
	public void setPassword(String password) throws InvalidPasswordException {
		if(password.matches("[A-Za-z0-9]+")==false || password.length()<6) {
           throw new InvalidPasswordException("password should only contain alphanumeric");
		}
		this.password = password;
	}
	

	
	@Override
	public int compareTo(Register o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
		
	
}
