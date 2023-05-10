package org.dissan.restaurant;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MainTest {

    private static boolean assertion;
    @BeforeClass
    public static void initiate(){
        assertion = true;
    }

    @Test
    public void mainTest(){
        assertTrue(assertion);
    }
}
