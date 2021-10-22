package com.study.singleton;

public class Tesla {
	private int serialNum = 210001;
	private static Tesla instance = null;
	
//	외부에서 생성되지 않도록 해야함.
//	private 사용
	private Tesla() {	
	}
	
	public static Tesla getInstance() {
		if(instance == null) {
			instance = new Tesla();
		}
		return instance;
	}
	
	public Car createCar(String model) {
		return new Car(serialNum++, model, getClass().getSimpleName());
	}
	
	
}
