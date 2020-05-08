package com.example.ticketBooking.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ticketBooking.dto.UserDto;
import com.example.ticketBooking.entity.Details;
import com.example.ticketBooking.entity.User;
import com.example.ticketBooking.exceptions.NoPlanesAvalaibleException;
import com.example.ticketBooking.service.DestinationService;
import com.example.ticketBooking.service.DetailsService;
import com.example.ticketBooking.service.UserService;
@Controller
public class AppController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private DestinationService destinationService;
	
	@Autowired
	private DetailsService detailsService;
	
	@GetMapping(value="/")
	public String printhello(){
		return "index";
		
	}
	@GetMapping(value = "/register")
	public ModelAndView registerUser() {
		UserDto user=new UserDto();
		ModelAndView mav=new ModelAndView("user");
		mav.addObject("user",user);
		return mav;
	}
	
		
	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user")UserDto user) {
		userService.registerUser(user);
	    return "redirect:/";       
	}
	@GetMapping("/travelbooking")
	public String booktraveller(Model model) {
		List<UserDto> users=userService.getAllUser();
		List<String> sources=destinationService.getAllSources();
		List<String> destinations=destinationService.getAllDestinations();
		model.addAttribute("sources", sources);
		model.addAttribute("destinations", destinations);
		model.addAttribute("users",users);
		return "travelBooking";
	}
	
	@PostMapping("/saveDetail")
	public String saveDetail(@ModelAttribute(name = "indexes") String indexes,Model model) throws ParseException{
		System.out.println(indexes);
		String[] inputs=indexes.split(",");
		for(String s:inputs) {
			System.out.println(s);
		}
		try{detailsService.saveDetails(inputs);
		return "redirect:/";}
		catch(NoPlanesAvalaibleException e) {
			model.addAttribute("error",e.getLocalizedMessage());
			return "sorry";
		}
	}
	@GetMapping("/booking")
	public String bookingDetails(Model model) {
		List<UserDto> users=userService.getAllUser();
		model.addAttribute("users",users);
		return "bookingdetails";
	}
	@GetMapping("/book")
	public String bookHistory(@ModelAttribute(name = "index") String index,Model model) throws ParseException{
		List<Details> details=detailsService.getAllDetails(index);
		model.addAttribute("details", details);
		return "bookingHistory";
	}
	@GetMapping(value = "/update/{id}")
	public String updateDetails(@PathVariable(name = "id") int id,Model model) {
		Details detail=detailsService.updateDetail(id);
		int id1=detail.getId();
		model.addAttribute("id1", id1);
		model.addAttribute("detail", detail);
		List<String> sources=destinationService.getAllSources();
		List<String> destinations=destinationService.getAllDestinations();
		model.addAttribute("sources", sources);
		model.addAttribute("destinations", destinations);
		return "updateDetail";
	}
	
	@PostMapping(value = "/updateBook/{id1}")
	public String updateBook(@PathVariable(name = "id1")int id1,@ModelAttribute(name = "indexes") String indexes) {
		System.out.println(id1);
		System.out.println("iiiiiiii");
		System.out.println("11"+indexes);
	try { detailsService.updateDetails(id1, indexes);return "redirect:/";}
	catch(NoPlanesAvalaibleException e) {
		return "sorry";
	}
	
	}
}
