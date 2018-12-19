package com.test.service;

import com.test.NotAuthrized;
import com.test.model.User;
import com.test.model.User.Adult;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

@Service
@Validated
public class UserServiceImpl1 implements UserService1{

    @Override
    public void valideUserWithInline( @NotNull @Valid @Validated(value={Default.class,Adult.class}) User user) throws NotAuthrized{
       
         if(user.getIsAdult().isEmpty()){
            
            throw new NotAuthrized("NotAuthrized");
        }
        
    }

      
}
