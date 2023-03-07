package com.example.pratice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pratice.model.AbhiDetails;
import com.example.pratice.pojo.AbhiDetailsPojo;

@Repository
public interface AbhiDetailsRepo extends JpaRepository<AbhiDetails, Integer> {
	
	//AbhiDetailsPojo save(AbhiDetailsPojo abhiDetailsRecord);

}
