package org.dissan.restaurant.models;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestLoggedUser {

    private static Logger logger;
    @BeforeClass
    public static void initiate(){
        logger = Logger.getLogger(TestLoggedUser.class.getSimpleName());
    }

    @Test
    public void goodDateTest() throws FileNotFoundException {

        String path = Objects.requireNonNull(TestLoggedUser.class.getResource("dateInput.json")).getPath();
        BufferedReader reader = new BufferedReader(
                new FileReader(path)
        );
        JsonElement jsonElement = JsonParser.parseReader(reader);
        boolean assertionResult = true;
        JsonObject object = jsonElement.getAsJsonObject();
        Set<String> dates = object.keySet();
        ConcreteUser concreteUser = new ConcreteUser("test", "test");


        for (String date : dates){
            try {
                String testDate = object.get(date).getAsString();
                concreteUser.setDateOfBirth(testDate);
                logger.info("passed: " + testDate);
            } catch (ParseException e) {
                assertionResult = false;
            }
        }

        assertTrue(assertionResult);
    }


}
