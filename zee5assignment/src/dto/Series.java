package dto;

import java.util.Objects;

import app.Exception.LocationNotFoundException;
import app.Exception.NameNotFoundException;
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
public class Series implements Comparable<Series> {
	public Series(String sid, String scat, String sname,String sdor, String slanguage, String slength,String strailer,String scast)
			throws NameNotFoundException,LocationNotFoundException {
		super();
		this.setSid(sid);
		this.setScat(scat);
		this.setSname(sname);
		this.setScast(scast);
		this.setSdor(sdor);
		this.setSlanguage(slanguage);
		this.setSlength(slength);
		this.setStrailer(strailer);
	}
	 @Setter(value = AccessLevel.NONE)
	 private String sid;
	 private String scat;
	 @Setter(value = AccessLevel.NONE)
	 private String sname;
	 private String sdor;
	 private String slanguage;
	 private String slength;
	 private String strailer;
	 private String scast;
	 public void setSid(String sid) throws LocationNotFoundException{
		 if(sid==null || sid=="" || sid.length()<5) {
				throw new LocationNotFoundException("Series not found");
			}
			this.sid = sid;
	 }
	 public void setSname(String sname) throws NameNotFoundException{
		 if(sname==null || sname=="" || sname.length()>20) {
				throw new NameNotFoundException("seriesname is not found");
			}
			this.sname = sname;
	 }
	@Override
	public int hashCode() {
		return Objects.hash(scast, scat, sdor, sid, slanguage, slength, sname, strailer);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Series other = (Series) obj;
		return Objects.equals(scast, other.scast) && Objects.equals(scat, other.scat)
				&& Objects.equals(sdor, other.sdor) && Objects.equals(sid, other.sid)
				&& Objects.equals(slanguage, other.slanguage) && Objects.equals(slength, other.slength)
				&& Objects.equals(sname, other.sname) && Objects.equals(strailer, other.strailer);
	}
	 
	@Override
	public int compareTo(Series o) {
		// TODO Auto-generated method stub
		return o.sid.compareTo(this.getSid());
	}
}
