package com.example.pratice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AbhiDetailsPojo {

	private int Id;
	private String name;
	private String address;
	private MadhuDetailsPojo madhudetails;
	

}
