package com.example.pratice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "madhu_details_table")
public class MadhuDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "madhu_id")
	private int madhuId;
	private String name;
	private String address;

	

	public MadhuDetails(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
}
