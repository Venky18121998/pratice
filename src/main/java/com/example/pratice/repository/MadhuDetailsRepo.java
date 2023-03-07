package com.example.pratice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pratice.model.MadhuDetails;

@Repository
public interface MadhuDetailsRepo extends JpaRepository<MadhuDetails, Integer> {

}
