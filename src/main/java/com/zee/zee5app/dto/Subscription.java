package com.zee.zee5app.dto;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.Exception.InvalidAmountException;
import com.zee.zee5app.Exception.LocationNotFoundException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
//@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="subscription")
public class Subscription implements Comparable<Subscription>{
	
//	 public Subscription(String id, String type, String dop, String status, String country, String payAmount,
//			String paymentmode, String autorenewal, String doe) throws LocationNotFoundException,InvalidAmountException{
//		super();
//		this.id = id;
//		this.type = type;
//		this.dop = dop;
//		this.status = status;
//		this.country = country;
//		this.payAmount = payAmount;
//		this.paymentmode = paymentmode;
//		this.autorenewal = autorenewal;
//		this.doe = doe;
//	}
	 @Id
	 
	 @NotBlank
	 private String id;
	 private String type;
	 @NotNull
	 private String dop;
	 @NotBlank
	 private String status;
	 private String country;
	 @NotBlank
	 private String payAmount;
	 private String paymentmode;
	 private String autorenewal;
	 @NotNull
	 private String doe;
	 public void setId(String id) throws LocationNotFoundException{
		 if(id==null || id=="" || id.length()<5) {
				throw new LocationNotFoundException("Subscription not found");
			}
			this.id = id;
	 }
	 public void setPayAmount(String payAmount) throws InvalidAmountException{
		 if(payAmount==null || payAmount=="" || !(payAmount=="299" || payAmount=="499")) {
				throw new InvalidAmountException("Amount is not valid");
			}
			this.payAmount = payAmount;
	 }
	@Override
	public int hashCode() {
		return Objects.hash(autorenewal, country, doe, dop, id, payAmount, paymentmode, status, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscription other = (Subscription) obj;
		return Objects.equals(autorenewal, other.autorenewal) && Objects.equals(country, other.country)
				&& Objects.equals(doe, other.doe) && Objects.equals(dop, other.dop) && Objects.equals(id, other.id)
				&& Objects.equals(payAmount, other.payAmount) && Objects.equals(paymentmode, other.paymentmode)
				&& Objects.equals(status, other.status) && Objects.equals(type, other.type);
	}
	 
	@OneToOne
	@JoinColumn(name = "regId")
	private User register;
	@Override
	public int compareTo(Subscription o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}
	 
}
