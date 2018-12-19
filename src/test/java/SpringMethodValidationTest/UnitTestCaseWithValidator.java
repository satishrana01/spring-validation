package SpringMethodValidationTest;

import com.test.NotAuthrized;
import com.test.SpringBootWebApplication;
import com.test.model.User;
import com.test.model.User.Adult;
import com.test.service.UserService;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class)

public class UnitTestCaseWithValidator {

    private static Validator validator;

    @Autowired
    UserService service;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testService() throws NotAuthrized {

        User user = new User();
        user.setFistName("satish");
        user.setLastName("kumar");
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user, Default.class, Adult.class);
        assertEquals(1, constraintViolations.size());

    }
}
