package com.example.ticketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ticketBooking.entity.Details;
@Repository
public interface DetailsRepository extends JpaRepository<Details, Integer>{

}
