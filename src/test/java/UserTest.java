import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.example.User;
import org.hamcrest.collection.IsArrayContaining;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

public class UserTest {
    @Test
    public void testUserCreation() {
        User user = new User("john_doe", "password123");
        assertEquals("john_doe", user.getUsername());
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testUserCreationWithNullUsername() {
        assertThrows(IllegalArgumentException.class, () -> {
            new User(null, "password123");
        });
    }
    @Test
    public void testUserCreationWithNullPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            new User("john_doe", null);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "john_doe, password123, john_doe",
            "jane_doe, password321, jane_doe"
    })
    public void testParameterizedUserCreation(String username, String password, String expectedUsername) {
        User user = new User(username, password);
        assertEquals(expectedUsername, user.getUsername());
    }

    @Test
    public void testMatchers() {
        int age=25;
        User user = new User("john_doe", "password123");
        assertThat(user.getUsername(), startsWith("j"));
        assertThat(user.getPassword(), startsWith("p"));
        assertThat(user.getUsername(), endsWith("e"));
        assertThat(user.getPassword(), endsWith("3"));
        assertThat(user.getUsername(), containsString("john"));
        assertThat(user.getPassword(), containsString("password"));
        assertThat(user.getPassword(), not(emptyString()));
        assertThat(user.getPassword(), allOf(notNullValue(),not(emptyString()),startsWith("jo")));
    }
    @Test
    public void testMatchersNumbers() {
        int age=25;

        assertThat(age, is(25));
        assertThat(age, greaterThan(20));
        assertThat(age, lessThan(30));
        assertThat(age, greaterThanOrEqualTo(20));
        assertThat(age, lessThanOrEqualTo(30));
        assertThat(age, allOf(greaterThanOrEqualTo(20),lessThanOrEqualTo(40)));
        assertThat(age, notNullValue());
    }

    @Test
    public void testMatchersList() {
        List<String> fruits= Arrays.asList("Banane","Pomme","Orange");

        assertThat(fruits, hasItem("Banane"));
        assertThat(fruits, hasItems("Banane","Orange"));
        assertThat(fruits, hasSize(3));
        assertThat(fruits, contains("Banane","Pomme","Orange"));
        assertThat(fruits, containsInAnyOrder("Banane","Orange","Pomme"));

    }

    @Test
    public void testMatchersArray() {
        String[] fruits= {"Banane","Pomme","Orange"};

        assertThat(fruits, arrayWithSize(3));
        assertThat(fruits, arrayContaining("Banane","Pomme","Orange"));
        assertThat(fruits, arrayContainingInAnyOrder("Banane","Orange","Pomme"));

    }
}

