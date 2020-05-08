package com.example.ticketBooking.dto;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class UserDto {

	private int id;
	
	@Size(min = 3,message = "name length can't be less than 3")
	private String fullName;
    
    @Min(value = 18, message = "age can't be less than 18")
    @Column(name = "age")
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;

}

	public UserDto() {
		super();
	}

	public UserDto(int id, String fullName, @Min(value = 18, message = "age can't be less than 18") int age) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.age = age;
	}
}