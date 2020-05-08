package com.example.ticketBooking.service.destinationServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ticketBooking.entity.Destination;
import com.example.ticketBooking.repository.DestinationRepository;
import com.example.ticketBooking.service.DestinationService;
@Service
public class DestinationsServiceImpl implements DestinationService{

	@Autowired
	private DestinationRepository destinationRepo;
	
	@Override
	public List<String> getAllSources(){
		List<Destination> sources=destinationRepo.findAll();
		
		List<String> source= sources.stream().map(f->f.getSource()).collect(Collectors.toList());
		for(int i=0;i<source.size();i++) {
			for(int j=i+1;j<source.size();j++) {
				if(source.get(i).equalsIgnoreCase(source.get(j))) {
				    System.out.println(source.get(j)+"kkk"+source.get(i));
				    System.out.println(j);
					source.remove(source.get(j));
					j--;
				    }
					else {
						System.out.println(source.get(j)+"kkk"+source.get(i)+"jjjjjji");
						System.out.println(j);
					}
				}
			}
		
		
	   return source;
	}
	@Override
	public List<String> getAllDestinations(){
		List<Destination> destinations=destinationRepo.findAll();
		List<String>destination= destinations.stream().map(f->f.getDestination()).collect(Collectors.toList());
		for(int i=0;i<destination.size();i++) {
			for(int j=i+1;j<destination.size();j++) {
				if(destination.get(i).equalsIgnoreCase(destination.get(j))) {
					destination.remove(destination.get(j));
					j--;
				}
			}
		}
		return destination;}

}
