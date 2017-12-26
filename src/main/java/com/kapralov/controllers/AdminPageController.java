package com.kapralov.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kapralov.model.data.NewRoom;

@Controller
public class AdminPageController {

	@RequestMapping(value="/admin/addRoom", method = RequestMethod.GET)
	public String addRoomPage(Map<String, Object> model)
	{
		NewRoom room = new NewRoom();
		model.put("newRoom", room);
		return "addRoom";
	}
	
	
	@RequestMapping(value = "/admin/addNewRoom", method = RequestMethod.POST)
	public String addNewRoom(@ModelAttribute("newRoom") @Valid NewRoom room, BindingResult result)
	{
		if(result.hasErrors())
			return "redirect:/admin/addRoom?error=true";
		return "redirect:/admin/addRoom?success=true";
	}
	
}
