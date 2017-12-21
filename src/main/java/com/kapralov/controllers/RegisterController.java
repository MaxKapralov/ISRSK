package com.kapralov.controllers;


import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kapralov.model.data.NewUserForm;
import com.kapralov.model.data.User;
import com.kapralov.model.data.UserInfo;
import com.kapralov.model.repository.UserInfoRepository;
import com.kapralov.model.repository.UserRepository;

@Controller
public class RegisterController {

	@Autowired
	UserRepository repository;
	
	@Autowired
	UserInfoRepository userInfoRep;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model)
    {
        NewUserForm userForm = new NewUserForm();
        model.put("userForm", userForm);
        
        return "register";
    }
    
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") @Valid NewUserForm user, BindingResult result, Map<String, Object> model)
    {
        if(result.hasErrors())
            return "register";
        User newUser = repository.save(new User(user.getLogin(), user.getPassword()));
        userInfoRep.save(new UserInfo(newUser.getId(), user.getName(), user.getSurname(), user.getEmail(), user.getBirthday(), "ROLE_USER"));
        return "redirect:/result";
    }
    
    @RequestMapping(value="/result", method=RequestMethod.GET)
    public String result()
    {
    	return "result";
    }
}
