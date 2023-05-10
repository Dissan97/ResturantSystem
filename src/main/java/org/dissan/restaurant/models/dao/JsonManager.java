package org.dissan.restaurant.models.dao;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class JsonManager {

    private JsonManager(){}
    public static Set<String> keyGetter(@NotNull JsonObject jsonObject){
        return jsonObject.keySet();
    }
}
