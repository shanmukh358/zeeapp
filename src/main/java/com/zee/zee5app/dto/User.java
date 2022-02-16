package com.zee.zee5app.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidEmailException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.Exception.InvalidPasswordException;

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
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="reg",uniqueConstraints = { @UniqueConstraint(columnNames="username"),
		@UniqueConstraint(columnNames="email")})


public class User implements Comparable<User>{
	
//	public Register(String id, String firstName, String lastName, String email, String password)
//			throws InvalidIdLengthException, InvalidNameException,InvalidPasswordException,InvalidEmailException {
//		super();
//		this.setId(id);
//		this.setFirstName(firstName);
//		this.setLastName(lastName);
//		this.email = email;
//		this.password = password;
//	}
	@Id
	@Column(name="regId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	// it should have min length of 6.
	// we have to write a code to validate the length and 
	// then assign the value.
	
	@NotBlank
	@Size(max=20)
	private String username;
	
	@Size(max=50)
	private String firstname;
	@Size(max=50)
	
	private String lastname;
	@Size(max=50)
	@Email
	private String email;
	@Size(max=100)
	@NotBlank
	private String password;
	//@NotBlank for contact number
	
	public User() {
		// EDC
		// any kind of customization during the initialization of object
		// then its better to introduce EDC or PC or both as per the need.
		
		System.out.println("hello ");
	}

	
	public void setPassword(String password) throws InvalidPasswordException {
		if(password==null || password=="" || password.length()<6) {
 
		}
		this.password = password;
	}
	
	

	

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return o.id.compareTo(this.getId());
	}
	
	// private stuff will be accessible only inside the class.
	
	// setter : is used to set the value for a particular field.
	// getter : to get/return the value of a specific field
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user_roles",joinColumns = @JoinColumn(name="regId"),inverseJoinColumns = @JoinColumn(name="roleId"))
	private Set<Role> role=new HashSet<>();
	
	public User(String username,String firstname, String lastname, String email, String password) {
		this.username=username;
		this.firstname=firstname;
		this.lastname=lastname;
		this.email=email;
		this.password=password;
	}
	@JsonIgnore
	@OneToOne(mappedBy = "register", cascade = CascadeType.ALL)
	private Subscription subscription;
	
	
	@OneToOne(mappedBy = "register",cascade = CascadeType.ALL)
	private Login login;
	
	
	
}
