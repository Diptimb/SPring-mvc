package com.example.ticketBooking.service;

import java.util.List;

import com.example.ticketBooking.dto.UserDto;
import com.example.ticketBooking.entity.User;

public interface UserService {
 UserDto registerUser(UserDto userdto) ;

 List<UserDto> getAllUser();

}
