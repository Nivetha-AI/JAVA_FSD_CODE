package com.hex.hiberembedd.com.hex.hiberembedd;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="schoolStudent")
public class Student {
  @Id
 
 int Roll;
 String name;
 Double Fee;

 Result res;
 
public Result getRes() {
	return res;
}
public void setRes(Result res) {
	this.res = res;
}
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
public Double getFee() {
	return Fee;
}
public void setFee(Double fee) {
	Fee = fee;
}
@Override
public String toString() {
	return "Student [Roll=" + Roll + ", name=" + name + ", Fee=" + Fee + "]";
}
 
}
