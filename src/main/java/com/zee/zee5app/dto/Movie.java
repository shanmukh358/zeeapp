package com.zee.zee5app.dto;


import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.zee.zee5app.Exception.LocationNotFoundException;
import com.zee.zee5app.Exception.NameNotFoundException;

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
//@AllArgsConstructor
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "mname") }, name = "movie")
public class Movie implements Comparable<Movie> {
//	public Movie(String mid, String mcat, String mname,String mdor, String mlanguage, int mlength,String mtrailer,String mcast)
//			throws NameNotFoundException,LocationNotFoundException {
//		super();
//		this.setMid(mid);
//		this.setMcat(mcat);
//		this.setMname(mname);
//		this.setMcast(mcast);
//		this.setMdor(mdor);
//		this.setMlanguage(mlanguage);
//		this.setMlength(mlength);
//		this.setMtrailer(mtrailer);
//	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	@Length(min=4)
	 private Long mid;
	@NotBlank
	 private String mname;
	 private String mcat;
	
	 @NotBlank
	 private String mdor;
	 private String mcast;
	 
	 @NotNull
	 @Min(value = 1)
	 private int mlength;
	 @NotBlank
	 private String mlanguage;
	 @NotNull
	 private String mtrailer;
	
	 
	
	 
//	 public void setMname(String mname) throws NameNotFoundException{
//		 if(mname==null || mname=="" || mname.length()>20) {
//				throw new NameNotFoundException("moviename is not found");
//			}
//			this.mname = mname;
//	 }
//	@Override
//	public int hashCode() {
//		return Objects.hash(mcast, mcat, mdor, mid, mlanguage, mlength, mname, mtrailer);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Movie other = (Movie) obj;
//		return Objects.equals(mcast, other.mcast) && Objects.equals(mcat, other.mcat)
//				&& Objects.equals(mdor, other.mdor) && Objects.equals(mid, other.mid)
//				&& Objects.equals(mlanguage, other.mlanguage) && Objects.equals(mlength, other.mlength)
//				&& Objects.equals(mname, other.mname) && Objects.equals(mtrailer, other.mtrailer);
//	}
	
	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return o.mid.compareTo(this.getMid());
	}




public Movie( @NotBlank String mname, String mcat, @NotBlank String mdor, String mcast,
		@NotNull @Min(1) int mlength, @NotBlank String mlanguage, @NotNull String mtrailer) {
	
	this.mname = mname;
	this.mcat = mcat;
	this.mdor = mdor;
	this.mcast = mcast;
	this.mlength = mlength;
	this.mlanguage = mlanguage;
	this.mtrailer = mtrailer;
}
	
}
