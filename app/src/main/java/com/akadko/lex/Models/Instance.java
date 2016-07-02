package com.akadko.lex.Models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by akadko on 01.07.2016.
 */
public class Instance {

    private int id;
    private String name;
    private boolean isCurrent;

    public Instance(int id, String name, boolean isCurrent) {
        this.id = id;
        this.name = name;
        this.isCurrent = isCurrent;
    }

    public Instance() {
    }

    public static Instance parseJSON(JSONObject json) throws JSONException {
        int id = json.getInt("id");
        String name = json.getString("name");
        boolean isCurrent = json.getBoolean("isCurrent");

        return new Instance(id, name, isCurrent);
    }

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

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(boolean isCurrent) {
        this.isCurrent = isCurrent;
    }
}
