package com.example.pratice.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "abhi_details_table")
public class AbhiDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int Id;
	private String name;
	private String address;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_madhu_id")
	private MadhuDetails madhudetails;

	public AbhiDetails(String name, String address, MadhuDetails madhudetails) {
		super();
		this.name = name;
		this.address = address;
		this.madhudetails = madhudetails;
	}

}
