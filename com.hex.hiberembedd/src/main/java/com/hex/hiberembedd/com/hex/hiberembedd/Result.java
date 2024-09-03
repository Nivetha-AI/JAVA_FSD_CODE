package com.hex.hiberembedd.com.hex.hiberembedd;

import javax.persistence.Embeddable;

@Embeddable
public class Result {
 int marks;
 String sub;
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks = marks;
}
public String getSub() {
	return sub;
}
public void setSub(String sub) {
	this.sub = sub;
}
@Override
public String toString() {
	return "Result [marks=" + marks + ", sub=" + sub + "]";
}
 
}
