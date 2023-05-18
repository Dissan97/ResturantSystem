package org.dissan.restaurant.models.dao.user;

import org.dissan.restaurant.cli.utils.OutStream;
import org.dissan.restaurant.controllers.exceptions.UserAlreadyExistException;
import org.dissan.restaurant.models.AbstractUser;
import org.dissan.restaurant.models.ConcreteUser;
import org.dissan.restaurant.models.UserRole;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Logger;

public class UserDao {
    private boolean local = true;
    public static final Logger LOGGER = Logger.getLogger(UserDao.class.getSimpleName());
    public AbstractUser getUserByUsername(String username){
        JSONObject object;
        //Choosing to which persistence model get from my data
        if (this.isLocal()) {
            object = UserDaoFs.getUserByUserName(username);
        } else {
            object = UserDaoDb.getUserByUserName(username);
        }
        if (object == null){
            return null;
        }
        //Filling user data
        AbstractUser user = new ConcreteUser();
        user.setUsername(username);
        user.setPassword(object.getJSONArray(username).getString(0));
        user.setName(object.getJSONArray(username).getString(1));
        user.setSurname(object.getJSONArray(username).getString(2));
        user.setCityOfBirth(object.getJSONArray(username).getString(3));
        try {
            user.setDateOfBirth(object.getJSONArray(username).getString(4));
        } catch (ParseException e) {
            LOGGER.info(e.getMessage());
        }
        UserRole role = UserRole.valueOf(object.getJSONArray(username).getString(5));
        OutStream.println(role.name());
        user.setRole(role);
        return user;
        }

    public void putUser(@NotNull AbstractUser userData) throws IOException, UserAlreadyExistException {


        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();
        array.put(userData.getPassword());
        array.put(userData.getName());
        array.put(userData.getSurname());
        array.put(userData.getCityOfBirth());
        array.put(userData.getDateOfBirth());
        array.put(userData.getRole().name());
        object.put(userData.getUsername(), array);

        if (this.isLocal()){
            UserDaoFs.putUser(object);
        }else {
            UserDaoDb.putUser(object);
        }
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    public boolean isLocal() {
        return local;
    }

}
