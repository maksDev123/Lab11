package test.java;

import org.junit.jupiter.api.Test;

import com.example.BuilderPattern.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test1 {

    @Test
    public void testNoReturn() {
        
        User user = User.builder().age(100).name("Mick").build();
        assertTrue(user.getAge() == 100);
        assertTrue(user.getName() == "Mick");

    }

}