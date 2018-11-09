package com.youtube.demo.controller;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtube.demo.model.User;
import com.youtube.demo.service.UserService;
import com.youtube.demo.utils.RestResponse;

@RestController
@ComponentScan("com.youtube.demo")
public class UserCotroller {
	
	@Autowired
	private UserService userService;
	
	protected ObjectMapper mapper;
	
	@RequestMapping(value="saveorupdate", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException {
		
		this.mapper = new ObjectMapper();
		User user = this.mapper.readValue(userJson, User.class);
		
		if(!this.validateUser(user)) {
			
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),"Los campos obligatorios no estan diligenciados");
		}
		this.userService.save(user);
		
		   return new RestResponse(HttpStatus.OK.value(),"Consulta Realizada de forma exitosa");
		
		
	}
	
	private boolean validateUser(User user) {
		
		boolean isValid = true;
		
		if(user.getFirst_name() == null || user.getFirst_name() == "") {
			isValid = false;
		}
		
		if(user.getFirst_surname() == null || user.getFirst_surname() == "") {
			isValid = false;
		}
		
		if(user.getAddress() == null || user.getAddress() == "") {
			isValid = false;
		}
		 
		return isValid;
	}
}
