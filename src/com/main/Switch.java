package com.main;

public class Switch {

	public static void main(String[] args) {
		System.out.println(simpleSwitch());
		System.out.println(complexSwitch());
		System.out.println(returnFromSwitch());
		System.out.println(isWeekDayV1_1(Day.SUN));		
		System.out.println(isWeekDayV1_2(Day.SUN));		
		System.out.println(isWeekDayV2(Day.SUN));
		System.out.println(objectSwitch());
	}

	enum Day {
		MON, TUE, WED, THUR, FRI, SAT, SUN
	};

	private static int objectSwitch() {
		Object o = new Person("Lee", 35);
		int result = 0;
		switch(o) {
		 case String s: result = 2;
		 		break;
		 case Integer i: result = 3;
		 		break;
		 case Person p: result = 1;
				break;		 		
		 case Long l: result = 4;
		 		break;
		 default: result = 10;
		}
		return result;
	}
	
	private static int simpleSwitch() {
		int i = 2;
		int result = 0;
		switch(i) {
		 case 1: result = 1;
				break;
		 case 2: result = 2;
		 		//break;
		 case 3: result = 3;
		 		break;
		 case 4,5,6,7,8,9: result = i;
		 		break;
		 default: result = 10;
		}
		return result;
	}

	private static int complexSwitch() {
		int i = 2;
		int result = 0;
		switch(i) {
		 case 1: result += 1;
				break;
		 case 2: result += 2;
		 		//break;
		 case 3: result += 3;
		 		break;
		 case 4: result += 4;
		 		break;
		 default: result += 10;
		}
		return result;
	}

	private static int returnFromSwitch() {
		int i = 2;
		switch(i) {
		 case 1: return 10;
		 case 2: return 20;
		 case 3: return 30;
		 case 4: return 40;
		 default: return 100;
		}
	}
	
	public static Boolean isWeekDayV1_1 (Day day)
	{
		Boolean result = switch(day) {
			case MON, TUE, WED, THUR, FRI -> true;
			case SAT, SUN -> false;
		};
		return result;
	}

	public static Boolean isWeekDayV1_2 (Day day)
	{
		Boolean result = switch(day) {
			case MON, TUE, WED, THUR, FRI : yield true;
			case SAT, SUN : yield false;
		};
		return result;
	}


	public static Boolean isWeekDayV2 (Day day)
	{
		Boolean result = switch(day) {
			case MON, TUE, WED, THUR, FRI ->
			{
				System.out.println("It is WeekDay");
				yield true;
			}
			case SAT, SUN ->
			{
				System.out.println("It is Weekend");
				yield false;
			}
		};
		return result;
	}
	
	
}
