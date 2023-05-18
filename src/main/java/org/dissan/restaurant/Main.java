package org.dissan.restaurant;

import org.dissan.restaurant.beans.BadCommanEntryException;
import org.dissan.restaurant.controllers.exceptions.UserAlreadyExistException;
import org.dissan.restaurant.controllers.exceptions.UserCredentialException;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

public class Main {


    public static void main(String...args) throws BadCommanEntryException, UserCredentialException, UserAlreadyExistException, ParseException, IOException {

        JSONArray array = new JSONArray();
        JSONObject ob = new JSONObject();
        JSONObject ob1 = new JSONObject();

        ob.put("a", "ciao");
        ob1.put("b", "via via");

        array.put(ob1);
        array.put(ob);

        Set<String> k = new HashSet<>();
        k.add("A");
        k.add("B");


        System.out.println(k.contains("C"));

    }
}
