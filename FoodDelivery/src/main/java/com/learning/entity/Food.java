package com.learning.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="food")
public class Food implements Comparable<Food>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int foodId;
	
	@Size(max=50)
	@NotBlank
	private String foodname;
	
	private int foodcost;
	private String description;
	private String foodPic;

	@Override
	public int compareTo(Food o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@ManyToMany
	@JoinTable(name = "ft_food", joinColumns = @JoinColumn(name = "foodId"), 
			inverseJoinColumns = @JoinColumn(name = "foodTypeId"))
	private Set<FoodType> foodTypes = new HashSet<>();
}
