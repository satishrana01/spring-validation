package SpringMethodValidationTest;

import com.test.NotAuthrized;
import com.test.SpringBootWebApplication;
import com.test.model.User;
import com.test.service.UserService;
import com.test.service.UserService1;
import com.test.service.UserService2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class)
@ContextConfiguration({
        "classpath:validation-aspect-context.xml"
})
public class UnitTestCases {

    @Autowired
    UserService service;

    @Autowired
    UserService1 service1;

    @Autowired
    UserService2 service2;

    /***
     * In this test case group validation not get triggered.
     * 
     */
    @Test(expected = ConstraintViolationException.class)
    public void testvalideUser() throws NotAuthrized {

        User user = new User();
        user.setFistName("AAA");
        user.setLastName("BBB");

        service.valideUser(user);

    }

    /***
     * In this test case group validation not get triggered.
     * 
     */
    @Test(expected = ConstraintViolationException.class)
    public void testValideUserWithInline() throws NotAuthrized {

        User user = new User();
        user.setFistName("AAA");
        user.setLastName("kumar");
        // user.setIsAdult("CCC");

        service1.valideUserWithInline(user);

    }

    /***
     * In this test case Default validation not get triggered.
     * 
     */
    @Test(expected = ConstraintViolationException.class)
    public void testValideUserAtClassLavel() throws NotAuthrized {

        User user = new User();
        user.setFistName("AAA");
        // user.setLastName("BBB");
        user.setIsAdult("CCC");
        service2.valideUser(user);

    }
}
