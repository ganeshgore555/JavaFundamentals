package com.main;

public class Enum {
	public enum Direction{
		
		NORTH("Up"), SOUTH("Down"), EAST("Right"), WEST("Left");

		String description;
		
		private Direction(String description) {
			this.description = description;
		}
	}
}
