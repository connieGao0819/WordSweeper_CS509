package com.wpi.controller;

import com.wpi.layout.CreateGameLayout;
import com.wpi.layout.HomeLayout;
import com.wpi.models.Model;
import com.wpi.xml.Message;

public class FindWordRequestController {
	
	public CreateGameLayout app;
	public Model model;
	
	public FindWordRequestController(CreateGameLayout a, Model m) {
		this.app = a;
		this.model = m;
	}

}
