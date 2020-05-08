package com.example.ticketBooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ticketBooking.entity.Destination;
@Repository
public interface DestinationRepository extends JpaRepository<Destination, Integer>{
List<Destination> findBySource(String source);
}
