package com.javaproject.rnd;

public class stringformat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i = 1; i <= 12; i++) {
			String month = String.format("%02d", i);
			System.out.println(month);
		}
	}

}
