package com.test.service;

import com.test.NotAuthrized;
import com.test.model.User;
import com.test.model.User.Adult;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;


public interface UserService1 {

      
    void valideUserWithInline( @NotNull @Valid @Validated(value={Default.class,Adult.class}) User user) throws NotAuthrized;
  
    
}
