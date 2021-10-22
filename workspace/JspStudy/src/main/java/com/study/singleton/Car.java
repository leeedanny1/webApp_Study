package com.study.singleton;

public class Car {
	private int serialNum;
	private String model;
	private String company;
	
	public Car(int serialNum, String model, String company) {
		super();
		this.serialNum = serialNum;
		this.model = model;
		this.company = company;
	}
	
	public int getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Override
	public String toString() {
		return "Car [serialNum=" + serialNum + ", model=" + model + ", company=" + company + "]";
	}
	
	
}
