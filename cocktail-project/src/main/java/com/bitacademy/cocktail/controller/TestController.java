package com.bitacademy.cocktail.controller;

// hibernate 버전 확인
public class TestController {

	public static void main(String[] args) {
	    try {
	        System.out.println(org.hibernate.Version.getVersionString());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	}

}
