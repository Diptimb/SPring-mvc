package com.example.ticketBooking.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "details")
public class Details {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

@Column(name = "date")
private String date;

@Column(name = "food_type")
private String foodType;

@Column(name = "passport")
private boolean passport=false;



@Column(name = "visa")
private boolean visa;

@Column(name = "price")
private double price;

public Details(int id, String date, String foodType, boolean passport, boolean visa, double price, User user,
		Destination destination) {
	super();
	this.id = id;
	this.date = date;
	this.foodType = foodType;
	this.passport = passport;
	this.visa = visa;
	this.price = price;
	this.user = user;
	this.destination = destination;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

@OneToOne
private User user;

@OneToOne(cascade = CascadeType.PERSIST)
private Destination destination;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public String getFoodType() {
	return foodType;
}

public void setFoodType(String foodType) {
	this.foodType = foodType;
}

public boolean isPassport() {
	return passport;
}

public void setPassport(boolean passport) {
	this.passport = passport;
}

public boolean isVisa() {
	return visa;
}

public void setVisa(boolean visa) {
	this.visa = visa;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Destination getDestination() {
	return destination;
}

public void setDestination(Destination destination) {
	this.destination = destination;
}

public Details() {
	super();
}

	
}
