package com.test.service;

import com.test.NotAuthrized;
import com.test.model.User;
import com.test.model.User.Adult;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.groups.Default;

@Service
@Validated
public class UserServiceImpl implements UserService{

    @Override
    @Validated(value={Default.class,Adult.class})
    public void valideUser(User user) throws NotAuthrized {
       
         if(user.getIsAdult().isEmpty()){
            
            throw new NotAuthrized("NotAuthrized");
        }
        
    }

      
}
