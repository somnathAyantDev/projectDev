package com.boot.boot;

import java.io.Serializable;

public class Student implements Serializable{
		/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2060403888851749160L;
		private String name;
		private Integer roll;
		
		//getter and setter
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getRoll() {
			return roll;
		}
		public void setRoll(Integer roll) {
			this.roll = roll;
		}
		
		
		
		
	
}
