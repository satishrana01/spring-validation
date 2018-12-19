package com.test.service;

import com.test.NotAuthrized;
import com.test.model.User;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


public interface UserService {

      
    void valideUser( @NotNull @Valid User user) throws NotAuthrized;
  
    
}
