package com.example.pratice;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.pratice.controller.ControllerClass;
import com.example.pratice.model.AbhiDetails;
import com.example.pratice.model.MadhuDetails;
import com.example.pratice.pojo.AbhiDetailsPojo;
import com.example.pratice.pojo.MadhuDetailsPojo;
import com.example.pratice.service.AbhiMadhuService;

@ExtendWith(SpringExtension.class)
public class ControllerClassTesting {

	@InjectMocks
	ControllerClass controllerClass;

	@Mock
	AbhiMadhuService abhiMadhuService;

	@Test
	@Order(1)

	public void creatingEmployeeDetails() {

		MadhuDetailsPojo madhu = new MadhuDetailsPojo(1, "madhu", "gurrapadia");
		AbhiDetailsPojo abhi = new AbhiDetailsPojo(2, "venkat", "ongole", madhu);
		if (Mockito.when(abhiMadhuService.saveDetails(abhi)).thenReturn(abhi) != null) {

			controllerClass.creatingEmployeeDetails(abhi);
		} else {

		}

	}

	@Test
	@Order(2)

	public void getDetailsPersons() {

		MadhuDetails madhu = new MadhuDetails(1, "madhu", "gurrapadia");
		List<AbhiDetails> abhi = new ArrayList<>();
		abhi.add(new AbhiDetails(2, "venky", "ongole", madhu));

		Mockito.when(abhiMadhuService.getAllDetails()).thenReturn(abhi);
		controllerClass.getDetailsPersons();

	}

	@Test
	@Order(3)

	public void fetchingDetailsBasedOnId() {

		MadhuDetails madhu = new MadhuDetails(1, "madhu", "gurrapadia");
		AbhiDetails abhi = new AbhiDetails(2, "venky", "ongole", madhu);
		int Id = 2;

		Mockito.when(abhiMadhuService.getDetailsById(Id)).thenReturn(abhi);
		controllerClass.fetchingDetailsBasedOnId(Id);

	}

	

}
