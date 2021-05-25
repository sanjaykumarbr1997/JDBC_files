package com.xworkz.vacapp;

import com.xworkz.vacapp.dto.VaccineDTO;

public class Vaccine {

	public static void main(String[] args) {
		
		VaccineDTO dto = new VaccineDTO();
		dto.setMfgDate("Jan 2021");
		dto.setName("covaxin");
		dto.setQuantity(20);
		
		System.out.println(dto.getMfgDate());
		System.out.println(dto.getName());
		System.out.println(dto.getQuantity());
	}

}
