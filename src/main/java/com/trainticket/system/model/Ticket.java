package com.trainticket.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "train_tickets")
public class Ticket {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String fromLocation;
 private String toLocation;
 private String userFirstName;
 private String userLastName;
 private String userEmail;
 private char seatSection;
 private double pricePaid;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFromLocation() {
	return fromLocation;
}
public void setFromLocation(String fromLocation) {
	this.fromLocation = fromLocation;
}
public String getToLocation() {
	return toLocation;
}
public void setToLocation(String toLocation) {
	this.toLocation = toLocation;
}
public String getUserFirstName() {
	return userFirstName;
}
public void setUserFirstName(String userFirstName) {
	this.userFirstName = userFirstName;
}
public String getUserLastName() {
	return userLastName;
}
public void setUserLastName(String userLastName) {
	this.userLastName = userLastName;
}
public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
public char getSeatSection() {
	return seatSection;
}
public void setSeatSection(char seatSection) {
	this.seatSection = seatSection;
}
public double getPricePaid() {
	return pricePaid;
}
public void setPricePaid(double pricePaid) {
	this.pricePaid = pricePaid;
}

 // getters and setters
}
