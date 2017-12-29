package com.kapralov.model.data;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import com.kapralov.model.validators.PasswordConstraint;
import com.kapralov.model.validators.PasswordsEqualsConstraint;

@PasswordsEqualsConstraint
public class NewUserForm {

	@NotNull @Size(min = 1,  max = 20)
	private String name;
	
	@NotNull @Size(min = 1,  max = 20)
	private String surname;
	
	@NotNull @Size(min = 4,  max = 20)
	private String login;
	
	@PasswordConstraint
	private String password;
	
	@PasswordConstraint
	private String passAgain;
	
	@Email @NotNull 
	private String email;
	
	@DateTimeFormat(pattern = "dd.MM.YYYY")
	private Date birthday;
	
	@NotNull
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassAgain() {
		return passAgain;
	}

	public void setPassAgain(String passAgain) {
		this.passAgain = passAgain;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
