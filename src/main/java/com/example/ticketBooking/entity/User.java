package com.example.ticketBooking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
    @Column(name = "fullname")
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

	public User(int id, String fullName, @Min(value = 18, message = "age can't be less than 18") int age) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.age = age;
	}

	public User(String fullName, @Min(value = 18, message = "age can't be less than 18") int age) {
		super();
		this.fullName = fullName;
		this.age = age;
	}

	public User() {
		super();
	}
    
    
    
}
