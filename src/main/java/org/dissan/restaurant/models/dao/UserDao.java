package org.dissan.restaurant.models.dao;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.dissan.restaurant.models.ConcreteUser;
import org.dissan.restaurant.exceptions.BadRoleException;
import org.dissan.restaurant.exceptions.LoginException;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;

public class UserDao {

    private static final String PATH = Objects.requireNonNull(UserDao.class.getResource("users.json")).getPath();
    private boolean isLocal = true;
    private final Logger LOGGER = Logger.getLogger(UserDao.class.getSimpleName());
    public UserDao() {

    }

    private JsonObject usersObject = null;

    private void getJsonElement() throws IOException {
        JsonElement element = null;
        try {
            element = JsonParser.parseReader(
                    new JsonReader(
                            new FileReader(PATH)
                    )
            );
        } catch (FileNotFoundException e) {
            try {
                putUser(null);
            } catch (IOException ex) {
                throw new IOException(ex);
            }
        }
        assert element != null;
        this.usersObject = element.getAsJsonObject();

    }

    public List<ConcreteUser> getUserList(){

        List<ConcreteUser> userList = new ArrayList<>();
        try {
            if (this.usersObject == null) {
                getJsonElement();
            }

            Set<String> usernames = JsonManager.keyGetter(this.usersObject);

            for (String usr: usernames){
                String pwd = this.usersObject.get(usr).getAsJsonObject().get("password").getAsString();
                userList.add(new ConcreteUser(usr, pwd));
            }

        } catch (IOException e) {
                e.printStackTrace();
        }


        return userList;
    }

    public ConcreteUser getUserByUsername(String usr) throws IOException, LoginException {

        if (this.usersObject == null){
            getJsonElement();
        }

        Set<String> keys = this.usersObject.keySet();

        if (keys.isEmpty() || !keys.contains(usr)){
            throw new LoginException();
        }

        JsonObject jObject = this.usersObject.getAsJsonObject(usr);
        //Retrieving the correct user
        ConcreteUser concreteUser = null;

        LOGGER.info("concrete user found: " + jObject.toString());

        try {
            concreteUser = new ConcreteUser(usr, jObject.get("password").getAsString(),
                    jObject.get("name").getAsString(), jObject.get("surname").getAsString(),
                    jObject.get("dateOfBirth").getAsString(),jObject.get("role").getAsString());
        } catch (ParseException e) {
            //TODO add parse exception and handle it
        } catch (BadRoleException e) {
            //TODO RETURN THIS EXCEPTION
            throw new RuntimeException(e);
        }


        return concreteUser;
    }

    public void putUser(ConcreteUser user) throws IOException {
        if (user == null){
            File file = new File(PATH);
            if (!file.createNewFile()){
                throw new IOException("unable to create the file");
            }
        }

        try(BufferedWriter writer = new BufferedWriter(
                new FileWriter(PATH, true)
        )){

        }
    }

}
