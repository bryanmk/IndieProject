package questie.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void getAge() {
        // create the object that has the method that I want to test
        User user = new User();

        // set birthdate for the user
        LocalDate birthDate = LocalDate.parse("1973-01-01");
        user.setDateOfBirth(birthDate);

        // create a variable for the expected value
        int expectedAge = 50;

        // call the method and get the actual value
        int actualAge = user.getAge();

        // compare the two values as pass or fail
        assertEquals(expectedAge, actualAge);

    }
}