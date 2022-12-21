package com.meban.votingapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.meban.votingapp.entity.IPAddress;
import com.meban.votingapp.entity.Person;
import com.meban.votingapp.repository.IPAddressRepository;
import com.meban.votingapp.repository.PersonRepository;
import com.meban.votingapp.utils.HttpUtils;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private IPAddressRepository iPAddressRepository;
	
	
	@GetMapping("/start")
	public ModelAndView addPersonForm(HttpServletRequest request) {
		String ip = HttpUtils.getRequestIP(request);
		//if ip exists
		
		Optional<IPAddress> ipaddrobj = iPAddressRepository.findByAddress(ip);
		
//		if(ipaddrobj.isPresent()) {
//			
//			//call "youve already submitted" page
//			
//			ModelAndView mav = new ModelAndView("youvealreadysubmitted");
//			Person person = new Person();
//			mav.addObject("person", person);
//			return mav;
//		}
//		else {
			//store ip address
//			IPAddress new_ip = new IPAddress();
//			new_ip.setAddress(ip);
//			iPAddressRepository.save(new_ip);
			
			ModelAndView mav = new ModelAndView("startpage");
			Person person = new Person();
			mav.addObject("person", person);
			return mav;
		//}
	}
	
	@GetMapping("/submitted")
	public ModelAndView submitPersonPage() {
		ModelAndView mav = new ModelAndView("submitted");
		return mav;
	}
	
	@PostMapping("/savePerson")
	public String savePerson(@ModelAttribute Person person) {
		//get name from frontend and check if exist in DB
		Optional<Person> p=personRepository.findByName(person.getName().toLowerCase());
		//if name exist in DB
		if(p.isPresent()) {
			
			//increment vote count
			Person new_person = new Person();
			new_person.setId(p.get().getId());
			new_person.setName(p.get().getName().toLowerCase());
			new_person.setNumberOfVotes((short) (p.get().getNumberOfVotes()+1));
			personRepository.save(new_person);
		}else {
			
			personRepository.save(person);
		}
		
		return "redirect:/submitted";
	}

}
