package com.zee.zee5app.dto;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.Exception.InvalidIdLengthException;


import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="episodes")
public class Episodes {
	@Id
    @Column(name="epiId")
	@NotBlank
	
	private String epiId;
	
	@NotNull
	private int epiLength;
	
	@NotBlank
	private String episodeName;
	
	@NotBlank
	private String location;
	@NotBlank
	private String seriesId;
	
	private String trailer;

	public void setEpiId(String id) throws InvalidIdLengthException {
		if (id.length() < 6) {
			throw new InvalidIdLengthException("id length is less than or equal to 6");
		}
		this.epiId = id;
	}

	public void setSeriesId(String id) throws InvalidIdLengthException {
		if (id.length() < 6) {
			throw new InvalidIdLengthException("id length is less than or equal to 6");
		}
		this.seriesId = id;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(epiId, epiLength, episodeName, location, series, seriesId, trailer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Episodes other = (Episodes) obj;
		return Objects.equals(epiId, other.epiId) && epiLength == other.epiLength
				&& Objects.equals(episodeName, other.episodeName) && Objects.equals(location, other.location)
				&& Objects.equals(series, other.series) && Objects.equals(seriesId, other.seriesId)
				&& Objects.equals(trailer, other.trailer);
	}
	
	

	@ManyToOne
    @JoinColumn(name="sid")
	private Series series;
}
