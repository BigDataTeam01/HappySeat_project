package com.javaproject.rnd;

public class ExclusiveOR {

	public static void main(String[] args) {
		int countPerson = 2; // 좌석을 선택하는 총 인원수
		
		int currentSeat = 2; // 현재 좌석 현황 0010 
		int selectSeat = 7;  // 좌석 선택 현황 0111  
		
		int EORSeat = currentSeat^selectSeat;
		System.out.println("result : " + EORSeat);
		
		int changeCount = countSelecteSeat(EORSeat);
		System.out.println("변화된 좌석 수 : "+ changeCount);
		
		if(countPerson >= changeCount) {
			System.out.println("가능");
		}
		else {
			System.out.println("불가능");
		}
		
	}
	
	
	private static int countSelecteSeat(int EORseat) {
		int count = 0;
		while(EORseat > 0) {
			count +=  EORseat & 1;
			EORseat = EORseat >> 1;
		}
		return count;
	}
	
}
