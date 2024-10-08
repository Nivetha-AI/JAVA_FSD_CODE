package com.hex.hibereonetoone.com.hex.hibereonetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	@Id
	
  int Roll;
  String name;
  @OneToOne(cascade = CascadeType.ALL)
 @JoinColumn(name="Certificate")
  Certificate ces;
public int getRoll() {
	return Roll;
}
public void setRoll(int roll) {
	Roll = roll;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Certificate getCes() {
	return ces;
}
public void setCes(Certificate ces) {
	this.ces = ces;
}
@Override
public String toString() {
	return "Student [Roll=" + Roll + ", name=" + name + ", ces=" + ces + "]";
}
  
  
  
}
