package test.java;

import com.example.BuilderPattern.User;

public class Test {

    @org.junit.jupiter.api.Test
    public void testNoReturn() {
        User user = new User.builder().age(10);
        assertTrue(user.getAge() == 10);
    }

}