package com.example.ticketBooking.service;

import java.text.ParseException;
import java.util.List;

import com.example.ticketBooking.entity.Details;
import com.example.ticketBooking.exceptions.NoPlanesAvalaibleException;

public interface DetailsService {

	Details saveDetails(String[] inputs) throws ParseException,NoPlanesAvalaibleException;

	List<Details> getAllDetails(String index) throws ParseException;
	

	Details updateDetails(int id, String inputs) throws NoPlanesAvalaibleException;

	Details updateDetail(int id);

}
