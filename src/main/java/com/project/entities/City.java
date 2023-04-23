package com.project.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_cities")
@NoArgsConstructor
@AllArgsConstructor

public class City {

	@Override
	public String toString() {
		return "City [city_id=" + city_id + ", city=" + city + ", state=" + state + "]";
	}

	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long city_id;
	
	@Column
	@NotNull
	private String city;
	
	@Column
	@NotNull
	private String state;

	public Long getCity_id() {
		return city_id;
	}

	public void setCity_id(Long city_id) {
		this.city_id = city_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
