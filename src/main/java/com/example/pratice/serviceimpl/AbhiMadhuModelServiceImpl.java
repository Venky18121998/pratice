package com.example.pratice.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pratice.exception.PersonDetailsAreAvailableOnThisId;
import com.example.pratice.model.AbhiDetails;
import com.example.pratice.model.MadhuDetails;
import com.example.pratice.pojo.AbhiDetailsPojo;
import com.example.pratice.pojo.MadhuDetailsPojo;
import com.example.pratice.repository.AbhiDetailsRepo;
import com.example.pratice.repository.MadhuDetailsRepo;
import com.example.pratice.service.AbhiMadhuService;

@Service
public class AbhiMadhuModelServiceImpl implements AbhiMadhuService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbhiMadhuModelServiceImpl.class);

	@Autowired
	AbhiDetailsRepo abhiDetailsRepo;

	@Autowired
	MadhuDetailsRepo madhuDetailsRepo;

	@Override
	public AbhiDetailsPojo saveDetails(AbhiDetailsPojo abhiDetailsPojo) {
		// TODO Auto-generated method stub

		LOGGER.info("creating persons details:{}", abhiDetailsPojo);
		MadhuDetails madhu = new MadhuDetails(abhiDetailsPojo.getMadhudetails().getName(),
				abhiDetailsPojo.getMadhudetails().getAddress());
		AbhiDetails abhi = new AbhiDetails(abhiDetailsPojo.getName(), abhiDetailsPojo.getAddress(), madhu);
		AbhiDetails ab = abhiDetailsRepo.save(abhi);
		MadhuDetailsPojo ma = new MadhuDetailsPojo(ab.getMadhudetails().getMadhuId(), ab.getMadhudetails().getName(),
				ab.getMadhudetails().getAddress());
		AbhiDetailsPojo abd = new AbhiDetailsPojo(ab.getId(), ab.getName(), ab.getAddress(), ma);
		return abd;

	}

	@Override
	public List<AbhiDetails> getAllDetails() {
		// TODO Auto-generated method stub

		LOGGER.info("getting all the details from database:{}");

		return abhiDetailsRepo.findAll();
	}

	@Override
	public AbhiDetails getDetailsById(int Id) {
		// TODO Auto-generated method stub

		Optional obj = abhiDetailsRepo.findById(Id);

		if (obj.isEmpty()) {
			throw new PersonDetailsAreAvailableOnThisId("No person available on this id ");
		}

		return (AbhiDetails) obj.get();
	}

	@Override
	public AbhiDetails updateDetailsBasedOnId(int Id, AbhiDetailsPojo abhiDetailsPojo) {
		// TODO Auto-generated method stub

		AbhiDetails abbulu = abhiDetailsRepo.findById(Id).orElseThrow(
				() -> new PersonDetailsAreAvailableOnThisId(Id + "Based on this id no persons are available for you"));

		if (abbulu != null) {
			abbulu.setId(Id);
			abbulu.setName(abhiDetailsPojo.getName());
			abbulu.setAddress(abhiDetailsPojo.getAddress());
			abbulu.getMadhudetails().setName(abhiDetailsPojo.getMadhudetails().getName());
			abbulu.getMadhudetails().setAddress(abhiDetailsPojo.getMadhudetails().getAddress());

		}

		return abhiDetailsRepo.save(abbulu);
	}
	

}
