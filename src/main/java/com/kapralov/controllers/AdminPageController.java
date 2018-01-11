package com.kapralov.controllers;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kapralov.model.data.NewRoom;
import com.kapralov.model.data.NewUserForm;
import com.kapralov.model.data.RoomBook;
import com.kapralov.model.data.User;
import com.kapralov.model.data.UserInfo;
import com.kapralov.model.repository.NewRoomRepository;
import com.kapralov.model.repository.RoomBookRepository;
import com.kapralov.model.repository.UserInfoRepository;
import com.kapralov.model.repository.UserRepository;

@Controller
public class AdminPageController {

	@Autowired
	NewRoomRepository newRoomRep;
	
	@Autowired 
	UserInfoRepository userInfoRep;
	
	@Autowired
	UserRepository userRep;
	
	@Autowired
	RoomBookRepository roomBookRep;
	
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
		if(newRoomRep.findByLocation(room.getLocation()) != null)
			return "redirect:/admin/addRoom?exists=true";
		newRoomRep.save(room);
		return "redirect:/admin/addRoom?success=true";
	}
	
	@RequestMapping(value="/admin/delRoom", method = RequestMethod.GET)
	public String deleteRoom(Map<String, Object> model)
	{
		Iterable<NewRoom> list = newRoomRep.findAll();
		model.put("listOfRooms", list);
		return "deleteRoom";
	}
	
	@RequestMapping(value="/admin/delRoomWithId", method = RequestMethod.GET)
	public String deleteRoomWithId(@RequestParam("id") Long id)
	{
		if(newRoomRep.findById(id) != null)
		{
			newRoomRep.delete(id);
			return "redirect:/admin/delRoom?deleted=true";
		}
		return "redirect:/admin/delRoom?deleted=false";
	}
	
	@RequestMapping(value = "/admin/userList", method = RequestMethod.GET)
	public String userList(Map<String, Object> model)
	{
		Iterable<UserInfo> list = userInfoRep.findAll();
		model.put("listOfUsers", list);
		return "userList";
	}
	@RequestMapping(value="/admin/addNewUser", method = RequestMethod.GET)
	public String addUser(Map<String, Object> model)
	{
		NewUserForm newUser = new NewUserForm();
		model.put("newUserForm", newUser);
		return "addNewUser";
	}
	@RequestMapping(value = "/admin/addNewUser", method = RequestMethod.POST)
	public String addNewUser(@ModelAttribute("newUserForm") @Valid NewUserForm user, BindingResult result, Map<String, Object> model)
	{
		if(result.hasErrors())
			return "/admin/addNewUser";
		User newUser = userRep.save(new User(user.getLogin(), user.getPassword()));
		userInfoRep.save(new UserInfo(newUser.getId(), user.getName(), user.getSurname(), user.getEmail(), user.getBirthday(), user.getRole()));
		return "redirect:/admin/addNewUser?success=true";
	}
	
	@RequestMapping(value = "/admin/bookRoom", method = RequestMethod.GET)
	public String bookRoomPage(Map<String, Object> model)
	{
		Iterable<NewRoom> list = newRoomRep.findAll();
		model.put("list", list);
		return "bookRoom";
	}
	
	@RequestMapping(value="/admin/bookRoomWithId", method = RequestMethod.GET)
	public String bookRoomWithId(@RequestParam("id") Long id, Map<String, Object> model)
	{
		NewRoom room = newRoomRep.findById(id);
		model.put("room", room);
		return "bookRoomWithId";
	}
}	
	