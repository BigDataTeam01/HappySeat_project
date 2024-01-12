package com.javaproject.rnd;

public class stringformat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// stringformat 연습
		for(int i = 1; i <= 12; i++) {
			String month = String.format("%02d", i);
			System.out.println(month);
		}

		// 바뀐 좌석의 숫자를 찾아내는 알고리즘
		// 좌석 배치도
		String a = "10011000";
		// 좌석 3개를 클릭
		String b = "10111011";
		// 문자열 a를 2진수 숫자로 변환
		int ia = Integer.parseInt(a, 2);
		int ib = Integer.parseInt(b, 2);
		 // ia와 ib를 XOR해서 선택된 좌석을 catch
		int iab = ia ^ ib;
		 // iab를 2진수 문자열로 변환
		String ab = Integer.toBinaryString(iab);
		 // 1의 개수를 세어줌 (변화된 개수)
		int count = 0;

		for (int i = 0; i < ab.length(); i++) { // 0부터 ab의 길이까지
			if (ab.charAt(i) == '1') { // 1인 문자열을 찾으면
				count++; // count에 1을 더해줌
			}
		}

		System.out.println(ia);
		System.out.println(ib);
		System.out.println(ab);
		System.out.println(count);

	}

}
