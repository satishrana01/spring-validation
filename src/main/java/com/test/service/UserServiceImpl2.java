package com.test.service;

import com.test.NotAuthrized;
import com.test.model.User;
import com.test.model.User.Adult;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.groups.Default;

@Service
@Validated(value={Adult.class})
public class UserServiceImpl2 implements UserService2{

    @Override
    @Validated(value={Default.class,Adult.class})
    public void valideUser(User user) throws NotAuthrized {
       
         if(user.getIsAdult().isEmpty()){
            
            throw new NotAuthrized("NotAuthrized");
        }
        
    }

      
}
