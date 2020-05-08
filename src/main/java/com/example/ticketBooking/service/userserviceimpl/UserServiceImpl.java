package com.example.ticketBooking.service.userserviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ticketBooking.dto.UserDto;
import com.example.ticketBooking.entity.User;
import com.example.ticketBooking.repository.UserRepository;
import com.example.ticketBooking.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	 @Autowired
	 private UserRepository userRepo;
	 
	 @Autowired
	 private ModelMapper modelmap;

	@Override
	public UserDto registerUser(UserDto userdto) {
		User user=userRepo.save(new User(userdto.getFullName(),userdto.getAge()));
		return modelmap.map(user,UserDto.class);
	}
	
	@Override
	public List<UserDto> getAllUser(){
		return modelmap.map(userRepo.findAll(),new TypeToken<List<UserDto>>(){}.getType());
	}
}
