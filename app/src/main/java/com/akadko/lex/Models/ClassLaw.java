package com.akadko.lex.Models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by akadko on 01.07.2016.
 */
public class ClassLaw {

    public ClassLaw(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ClassLaw() {
    }

    public static ClassLaw parseJSON(JSONObject json) throws JSONException {
        int id = json.getInt("id");
        String name = json.getString("name");
        ClassLaw classLaw = new ClassLaw(id, name);
        return classLaw;
    }

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
