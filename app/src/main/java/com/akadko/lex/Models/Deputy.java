package com.akadko.lex.Models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by akadko on 01.07.2016.
 */
public class Deputy {

    private int id;
    private String name;
    private String position;
    private boolean isCurrent;

    public Deputy(int id, String name, String position, boolean isCurrent) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.isCurrent = isCurrent;
    }

    public Deputy() {
    }

    public static Deputy parseJSON(JSONObject json) throws JSONException {
        int id = json.getInt("id");
        String name = json.getString("name");
        String position = json.getString("position");
        boolean isCurrent = json.getBoolean("isCurrent");

        return new Deputy(id, name, position, isCurrent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(boolean isCurrent) {
        this.isCurrent = isCurrent;
    }
}
