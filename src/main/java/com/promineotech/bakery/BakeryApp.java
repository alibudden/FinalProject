package com.promineotech.bakery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.promineotech.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class })
public class BakeryApp  {

	public static void main(String[] args) {
	    SpringApplication.run(BakeryApp.class, args);
	  //starts server. scans package folders starting with com

		

	}

}
