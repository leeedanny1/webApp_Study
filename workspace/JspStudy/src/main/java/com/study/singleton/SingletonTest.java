package com.study.singleton;

public class SingletonTest {

	public static void main(String[] args) {
		KIA factory1 = KIA.getInstance();
		KIA factory2 = KIA.getInstance();
		KIA factory3 = KIA.getInstance();
		KIA factory4 = KIA.getInstance();

		Car[] c = new Car[4];
		
		c[0] = factory1.createCar("k3");
		c[1] = factory2.createCar("k5");
		c[2] = factory3.createCar("k7");
		c[3] = factory4.createCar("k8");
		
		for (Car car : c) {
			System.out.println(car);
		}
		
		
		Tesla tfactory1 = Tesla.getInstance();
		Tesla tfactory2 = Tesla.getInstance();
		Tesla tfactory3 = Tesla.getInstance();
		Tesla tfactory4 = Tesla.getInstance();

		Car[] t = new Car[4];
		
		t[0] = tfactory1.createCar("model_3");
		t[1] = tfactory2.createCar("model_x");
		t[2] = tfactory3.createCar("model_y");
		t[3] = tfactory4.createCar("model_s");
		
		for (Car car : t) {
			System.out.println(car);
		}
	}

}
