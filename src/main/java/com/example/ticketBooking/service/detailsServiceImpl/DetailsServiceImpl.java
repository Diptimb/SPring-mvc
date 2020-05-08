package com.example.ticketBooking.service.detailsServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.soap.Detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.stereotype.Service;

import com.example.ticketBooking.entity.Destination;
import com.example.ticketBooking.entity.Details;
import com.example.ticketBooking.entity.User;
import com.example.ticketBooking.exceptions.NoDetailsAvailableException;
import com.example.ticketBooking.exceptions.NoPlanesAvalaibleException;
import com.example.ticketBooking.repository.DestinationRepository;
import com.example.ticketBooking.repository.DetailsRepository;
import com.example.ticketBooking.repository.UserRepository;
import com.example.ticketBooking.service.DetailsService;

@Service
public class DetailsServiceImpl implements DetailsService{

	@Autowired 
	private DetailsRepository detailRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private DestinationRepository destinationRepo;
	
	@Override
	public Details saveDetails(String[] inputs) throws ParseException,NoPlanesAvalaibleException {
		System.out.println(inputs.length);
		Details detail=new Details();
		Destination destination =new Destination();
		for(int i=inputs.length-1;i>=0;i--) {
			if(i==inputs.length-1) {
				System.out.println(inputs[i]);
				detail.setDate(inputs[i]);
			}
			 if(i==inputs.length-2) {
                 destination.setDestination(inputs[i]);
			}
			 if(i==inputs.length-3) {
				System.out.println(inputs[i]);
				destination.setSource(inputs[i]);
			}
			 if(i==inputs.length-4) {
				
				int id=Integer.parseInt(inputs[i]); User user=userRepo.findById(id).get();
				  detail.setUser(user);
			}
		     if(i==inputs.length-5) {
				detail.setFoodType(inputs[i]);
			}
		    if(i==inputs.length-6 && inputs[i].equalsIgnoreCase("Visa")) {
				detail.setVisa(true);}
			
			if(i==inputs.length-6 && inputs[i].equalsIgnoreCase("Passport")) {
				detail.setPassport(true);
			}
			else if(i==inputs.length-7 && inputs[i].equalsIgnoreCase("Passport")) {
				detail.setPassport(true);
			}
			}
		
		
		List<Destination> destinations=destinationRepo.findAll();
		for(Destination d:destinations) {
			if(d.getDestination().equals(destination.getDestination()) && d.getSource().equalsIgnoreCase(destination.getSource())) {
			 System.out.println(d);
				detail.setDestination(d);	
				detail.setPrice(price(detail));
			return detailRepo.save(detail);
		}}
		
		throw new NoPlanesAvalaibleException("Sorry No Planes available");}
	
	public Double price(Details detail) {
		double price=detail.getDestination().getDistance()*10;
		if(detail.getUser().getAge()>30 && detail.getUser().getAge()<50) {
			price=price-0.05*price;
		}
		else if(detail.getUser().getAge()<50) {
			price=price-0.1*price;
		}
		return price;
	}
	
	@Override
	public List<Details> getAllDetails(String index) throws ParseException{
		String[] indexed=index.split( ",");
		int id=Integer.parseInt(indexed[0]);
		System.out.println(id);
		String date=indexed[1];
		List<Details> detail=detailRepo.findAll();
		List<Details> details=detail.stream().filter(d->d.getUser().getId()==id).map(d->d).collect(Collectors.toList());
		for(Details d:details) {
			System.out.println(d.getUser().getId());
		}
	    details=detail.stream().filter(d->d.getDate().compareToIgnoreCase(date)>0).map(d->d).collect(Collectors.toList());
		details.stream().findAny().orElseThrow(()->new NoDetailsAvailableException("No prior booking details"));
	    return details;
	}
   @Override
	public Details updateDetails(int id,String inputs) throws NoPlanesAvalaibleException{
		String[] indexed=inputs.split( ",");
	    Details detail=detailRepo.findById(id).get();
	    System.out.println(detail.getDate());
	    List<Destination> destination=destinationRepo.findBySource(indexed[0]);
	  destination=destination.stream().filter(d->d.getDestination().equalsIgnoreCase(indexed[1])).collect(Collectors.toList());
		destination.stream().findAny().orElseThrow(()->new NoPlanesAvalaibleException("No planes available"));
Destination destination2=destination.get(0);
         detail.setDestination(destination2);
	detail.setPrice(price(detail));    
	return detailRepo.save(detail);
        
	}

@Override
public Details updateDetail(int id) {
	
	return detailRepo.findById(id).get();
}


	
}
