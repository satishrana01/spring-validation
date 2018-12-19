package com.test;

import com.test.model.User;
import com.test.service.UserService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @Autowired
    UserService service;
	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		
	    User user = new User();
	    user.setFistName("satish");
	    
	    try {
            service.valideUser(user);
        } catch (NotAuthrized e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    
	    model.put("message", this.message);
		return "welcome";
	}

}