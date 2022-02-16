package dto;


import java.util.Objects;

import app.Exception.LocationNotFoundException;
import app.Exception.NameNotFoundException;
import lombok.AccessLevel;
import lombok.Data;
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

public class Movie implements Comparable<Movie> {
	public Movie(String mid, String mcat, String mname,String mdor, String mlanguage, String mlength,String mtrailer,String mcast)
			throws NameNotFoundException,LocationNotFoundException {
		super();
		this.setMid(mid);
		this.setMcat(mcat);
		this.setMname(mname);
		this.setMcast(mcast);
		this.setMdor(mdor);
		this.setMlanguage(mlanguage);
		this.setMlength(mlength);
		this.setMtrailer(mtrailer);
	}
	@Setter(value = AccessLevel.NONE)
	 private String mid;
	 private String mcat;
	 @Setter(value = AccessLevel.NONE)
	 private String mname;
	 private String mdor;
	 private String mlanguage;
	 private String mlength;
	 private String mtrailer;
	 private String mcast;
	 public void setMid(String mid) throws LocationNotFoundException{
		 if(mid==null || mid=="" || mid.length()<5) {
				throw new LocationNotFoundException("Movie not found");
			}
			this.mid = mid;
	 }
	 public void setMname(String mname) throws NameNotFoundException{
		 if(mname==null || mname=="" || mname.length()>20) {
				throw new NameNotFoundException("moviename is not found");
			}
			this.mname = mname;
	 }
	@Override
	public int hashCode() {
		return Objects.hash(mcast, mcat, mdor, mid, mlanguage, mlength, mname, mtrailer);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(mcast, other.mcast) && Objects.equals(mcat, other.mcat)
				&& Objects.equals(mdor, other.mdor) && Objects.equals(mid, other.mid)
				&& Objects.equals(mlanguage, other.mlanguage) && Objects.equals(mlength, other.mlength)
				&& Objects.equals(mname, other.mname) && Objects.equals(mtrailer, other.mtrailer);
	}
	
	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return o.mid.compareTo(this.getMid());
	}
}
