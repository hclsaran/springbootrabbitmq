package com.saran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saran.model.Product;
import com.saran.service.RabbitSender;
@RestController
@RequestMapping("/api")
public class RabbitController {
	@Autowired
	RabbitSender sender;
	
	@GetMapping("/produce")
	public String producer(@RequestParam("prdName") String prdName,@RequestParam("prdDesc") String prdDesc) {
		Product p=new Product();
		 
		p.setPrdName(prdName);
		p.setPrdDesc(prdDesc);
	 
		
		sender.send(p);
		return "Your product is too low. Please increase your minimum buffer stock";
	}

}
