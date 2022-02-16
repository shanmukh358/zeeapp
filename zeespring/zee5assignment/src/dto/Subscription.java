package dto;

import java.util.Objects;

import app.Exception.InvalidAmountException;
import app.Exception.LocationNotFoundException;
import lombok.AccessLevel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
//@EqualsAndHashCode
@NoArgsConstructor
//@AllArgsConstructor
public class Subscription {
	
	 public Subscription(String id, String type, String dop, String status, String country, String payAmount,
			String paymentmode, String autorenewal, String doe) throws LocationNotFoundException,InvalidAmountException{
		super();
		this.id = id;
		this.type = type;
		this.dop = dop;
		this.status = status;
		this.country = country;
		this.payAmount = payAmount;
		this.paymentmode = paymentmode;
		this.autorenewal = autorenewal;
		this.doe = doe;
	}
	 @Setter(value = AccessLevel.NONE)
	 private String id;
	 private String type;
	 private String dop;
	 private String status;
	 private String country;
	 @Setter(value = AccessLevel.NONE)
	 private String payAmount;
	 private String paymentmode;
	 private String autorenewal;
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
	 
	 
	 
}
