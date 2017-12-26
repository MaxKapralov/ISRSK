package com.kapralov.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kapralov.model.data.User;
import com.kapralov.model.data.UserInfo;
import com.kapralov.model.repository.UserInfoRepository;
import com.kapralov.model.repository.UserRepository;

@Controller
public class StartController {
 
     @Autowired
     UserInfoRepository userInfo;
     
     @Autowired
     UserRepository user;
     
     
    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("welcome", "Witaj");
        return "welcome";
    }
 
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "admin";
    }
     
    @RequestMapping(value="/mainPage", method = RequestMethod.GET)
    public String mainPage(ModelMap model)
    {
    	Set<String> role = getRole();
    	if(role.contains("ROLE_ADMIN"))
    		return "redirect:/admin/mainPage";
    	return "redirect:/user/mainPage";
    }
 
    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }
 
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
 
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
    
    @RequestMapping(value = "/admin/mainPage", method = RequestMethod.GET)
	public String getAdminMainPage(ModelMap model)
	{
    	model.addAttribute("user", getPrincipal());
		return "adminMainPage";
	}
 
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        User userRep = (User) user.findByLogin(userName);
        UserInfo info = userInfo.findById(userRep.getId());
        userName = info.getName() + " " + info.getSurname();//???
        return userName;
    }
    
    private Set<String> getRole()
    {
    	Set<String> role = AuthorityUtils.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
    	return role;
    }
 
}
