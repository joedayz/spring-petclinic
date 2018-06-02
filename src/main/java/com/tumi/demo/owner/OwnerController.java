package com.tumi.demo.owner;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnerController {

	@Autowired
	private  OwnerRepository ownerRepository;
	
	@GetMapping("/owners/")
	public String processFindForm(Owner owner, Map<String, Object> model) {
		
		List<Owner> results = this.ownerRepository.findByLastName(owner.getLastName());
		
		model.put("selections", results);
		return "owners/ownersList";
	}
}
