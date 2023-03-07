package com.example.pratice.service;

import java.util.List;

import com.example.pratice.exception.PersonDetailsAreAvailableOnThisId;
import com.example.pratice.model.AbhiDetails;
import com.example.pratice.pojo.AbhiDetailsPojo;

public interface AbhiMadhuService {
	
	public AbhiDetailsPojo saveDetails(AbhiDetailsPojo abhiDetailsPojo);
	
	public List<AbhiDetails> getAllDetails();
	
	public AbhiDetails getDetailsById(int Id) throws PersonDetailsAreAvailableOnThisId;
	
	public AbhiDetails updateDetailsBasedOnId(int Id, AbhiDetailsPojo abhiDetailsPojo);

}
