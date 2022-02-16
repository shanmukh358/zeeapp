package com.zee.zee5app.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.Exception.LocationNotFoundException;
import com.zee.zee5app.Exception.NameNotFoundException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter

//@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Series implements Comparable<Series> {
//	public Series(String sid, String scat, String sname,String sdor, String slanguage, int slength,String strailer,String scast)
//			throws NameNotFoundException,LocationNotFoundException {
//		super();
//		this.setSid(sid);
//		this.setScat(scat);
//		this.setSname(sname);
//		this.setScast(scast);
//		this.setSdor(sdor);
//		this.setSlanguage(slanguage);
//		this.setSlength(slength);
//		this.setStrailer(strailer);
//	}
	@Id
	 
	 private String sid;
	 @NotBlank
	 private String sname;
	 private String scat;
	 
	 @NotBlank
	 private String sdor;
	 @NotBlank
	 private String scast;
	 @NotNull
	 @Min(value=1)
	 private int slength;
	 
	 @NotBlank
	 private String slanguage;
	 private String strailer;
	 
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
	public int compareTo(Series o) {
		// TODO Auto-generated method stub
		return o.sid.compareTo(this.getSid());
	}
	@Override
	public int hashCode() {
		return Objects.hash(episodes, scat, sdor, sid, slanguage, slength, sname, strailer);
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
		return Objects.equals(episodes, other.episodes) && Objects.equals(scat, other.scat)
				&& Objects.equals(sdor, other.sdor) && Objects.equals(sid, other.sid)
				&& Objects.equals(slanguage, other.slanguage) && slength == other.slength
				&& Objects.equals(sname, other.sname) && Objects.equals(strailer, other.strailer);
	}
	@OneToMany(mappedBy = "series",cascade=CascadeType.ALL)
	private List<Episodes> episodes =new ArrayList<>();
}
