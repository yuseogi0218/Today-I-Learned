package org.opentutorials.javatutorials.typeconversion;

public class TypeConversion {

	public static void main(String[] args) {
		// 자동(암시적) 형 변환
		// 자동 형 변환의 원칙은 표현범위가 좁은 데이터 타입에서 넓은 데이터 타입으로의 변환만 허용된다는 것이다.
		// byte -> short -> int -> long -> float -> double
		//			chr  -> int -> long -> float -> double
		int a = 3;
		float b = 1.0F;
		double c = a+b; 
		// a+b : int + float -> float + float = float
		//double c = -> float -> double
		
		// 수동(명시적) 형 변환
		// (데이터 타입)데이터 값
		float d = (float)100.0; // (float)double -> float
		int e = (int)100.0F; // (int)float -> int

	}

}
